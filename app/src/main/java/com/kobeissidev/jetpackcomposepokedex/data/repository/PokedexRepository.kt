package com.kobeissidev.jetpackcomposepokedex.data.repository

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.flatMap
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.Disposable
import coil.request.ImageRequest
import com.kobeissidev.jetpackcomposepokedex.data.local.PokeDatabase
import com.kobeissidev.jetpackcomposepokedex.data.model.evolution.Evolution
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.species.Species
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Color
import com.kobeissidev.jetpackcomposepokedex.data.paging.PokemonRemoteMediator
import com.kobeissidev.jetpackcomposepokedex.data.remote.PokeApiService
import com.kobeissidev.jetpackcomposepokedex.util.*
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.ByteArrayOutputStream
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette as CustomPalette

@ActivityScoped
class PokedexRepository(
    private val apiService: PokeApiService,
    private val database: PokeDatabase,
    private val application: Application,
    private val imageLoader: ImageLoader,
    val imageRequestList: MutableList<Disposable> = mutableListOf()
) {

    @ExperimentalPagingApi
    val remoteMediator = PokemonRemoteMediator(
        apiService = apiService,
        database = database
    )

    /**
     * Get the flow that is built using the Paging 3 Library.
     */
    @ExperimentalPagingApi
    val pokemonPagingFlow
        get() = Pager(
            config = PagingConfig(
                pageSize = PageSize,
                prefetchDistance = PageSize * 2,
                jumpThreshold = JumpThreshold
            ),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { database.pokedexDao().getAllPokemonEntries() }
        ).flow.map { pagingData ->
            withContext(Dispatchers.IO) {
                val pokemonFromDbList = database.pokedexDao().getAllPokemon()
                // We will flatten the PagingData so we can access all entries.
                pagingData.flatMap { pokemonEntry ->
                    // We only care about the results as they contain the Pokemon data needed so we will map those.
                    pokemonEntry.results.map { pokemon ->
                        // Create a Pokemon object with default values and set the name and id from the url.
                        (pokemonFromDbList.find { dbPokemon ->
                            // We already have an instance in the database so use that.
                            dbPokemon.name == pokemon.name
                        } ?: Pokemon(
                            originalName = pokemon.name,
                            id = pokemon.id
                        )).also { foundPokemon ->
                            // Only generate the background color if we don't have them saved in the database already.
                            if (foundPokemon.primaryPalette.isEmpty) {
                                generateBackgroundColor(pokemon = foundPokemon).collect {
                                    // Save this entry in the database so we can update it later.
                                    database.pokedexDao().insertPokemon(it)
                                }
                            }
                        }
                    }.filter { pokemon ->
                        // Filter out the special forms as they are not technically part of the Pokedex.
                        pokemon.id < SpecialFormStartingId
                    }
                }
            }
        }.flowOn(Dispatchers.IO)

    /**
     * Flow for keeping track of the Pokemon fetch result.
     */
    val fetchingStatusFlow = MutableStateFlow<NetworkResult<Pokemon>>(NetworkResult.Empty())
    val speciesFlow = MutableStateFlow<NetworkResult<Species>>(NetworkResult.Empty())
    val evolutionFlow = MutableStateFlow<NetworkResult<Evolution>>(NetworkResult.Empty())

    /**
     * Keep track of last failed fetched Pokemon so we could retry.
     */
    private var lastFailedFetchedPokemon: Pokemon? = null

    /**
     * Get the Pokemon using the Pokemon id
     */
    suspend fun fetchPokemon(pokemon: Pokemon) {
        lastFailedFetchedPokemon = null
        // Set initial state to the Loading so the UI could show a loading screen if necessary.
        fetchingStatusFlow.emit(NetworkResult.Loading())
        // Mainly just checking the type locally since every Pokemon will contain one.
        database.pokedexDao().getPokemon(pokemon.id)?.let { databasePokemon ->
            if (!databasePokemon.types.isNullOrEmpty()) {
                fetchingStatusFlow.emit(NetworkResult.Success(databasePokemon))
                return
            }
        }
        // Pokemon was not cached so fetch it.
        getResult { apiService.getPokemon(pokemon.id.toString()) }.suspendOnStateChanged(
            onSuccess = { networkPokemon ->
                // Fetched Pokemon successfully so update it in the database and emit the data to the flow
                val fetchedPokemon = networkPokemon.copy(paletteList = pokemon.paletteList)
                database.pokedexDao().updatePokemon(pokemon = fetchedPokemon)
                fetchingStatusFlow.emit(NetworkResult.Success(data = fetchedPokemon))
                fetchSpecies(pokemon = fetchedPokemon)
                fetchEvolutionChain()
            },
            onLoading = {
                // This callback will not be used for this API so mark we do not do anything in it.
                // Suspend functions cannot be inlined and defaulted so we need to define it.
            },
            onFailure = { message ->
                // Emit the failure message.
                fetchingStatusFlow.emit(NetworkResult.Failure(message = message))
                lastFailedFetchedPokemon = pokemon
            }
        )
    }

    private suspend fun fetchSpecies(pokemon: Pokemon) {
        speciesFlow.emit(NetworkResult.Empty())
        getResult { apiService.getPokemonSpecies(pokemon.id.toString()) }.suspendOnStateChanged(
            onSuccess = { species -> speciesFlow.emit(NetworkResult.Success(data = species)) },
            onLoading = { speciesFlow.emit(NetworkResult.Loading()) },
            onFailure = { message -> speciesFlow.emit(NetworkResult.Failure(message = message)) }
        )
    }

    private suspend fun fetchEvolutionChain() {
        evolutionFlow.emit(NetworkResult.Empty())
        speciesFlow.collect {
            it.suspendOnStateChanged(
                onSuccess = { species ->
                    val id = species.evolutionChain.url.extractId
                    getResult { apiService.getPokemonEvolutionChain(id) }.suspendOnStateChanged(
                        onSuccess = { chain -> evolutionFlow.emit(NetworkResult.Success(data = chain)) },
                        onLoading = { evolutionFlow.emit(NetworkResult.Loading()) },
                        onFailure = { message -> evolutionFlow.emit(NetworkResult.Failure(message = message)) }
                    )
                },
                onLoading = { evolutionFlow.emit(NetworkResult.Loading()) },
                onFailure = { message -> evolutionFlow.emit(NetworkResult.Failure(message = message)) })
        }
    }

    /**
     * Re-fetches the Pokemon if internet is available.
     */
    suspend fun refetchPokemon(context: Context) {
        if (context.isOnline) {
            lastFailedFetchedPokemon?.let { fetchPokemon(it) }
        } else Timber.e("No internet. Not re-fetching.")
    }

    /**
     * Generates the background color for a specific Pokemon
     * @param pokemon is the pokemon that we'll extract the image url from to generate the background color
     */
    private fun CoroutineScope.generateBackgroundColor(pokemon: Pokemon) = flow {
        if (!pokemon.primaryPalette.isEmpty) {
            emit(pokemon)
        } else {
            val request = ImageRequest.Builder(application)
                .data(pokemon.spriteUrl)
                .target { drawable ->
                    if (pokemon.primaryPalette.backgroundColor.isEmpty) {
                        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
                        Palette.from(bitmap).generate { palette ->
                            val stream = ByteArrayOutputStream()
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                            pokemon.paletteList = palette!!.swatches.map { swatch ->
                                CustomPalette(
                                    name = pokemon.name,
                                    backgroundColor = Color.fromComposeColor(swatch.rgb),
                                    titleTextColor = Color.fromComposeColor(swatch.titleTextColor),
                                    bodyTextColor = Color.fromComposeColor(swatch.bodyTextColor),
                                    drawableArray = stream.toByteArray(),
                                    isDefault = swatch == palette.dominantSwatch
                                )
                            }
                            launch(Dispatchers.IO) { emit(pokemon) }
                        }
                    } else launch(Dispatchers.IO) { emit(pokemon) }
                }
                .build()

            imageRequestList.add(imageLoader.enqueue(request))
        }
    }.flowOn(Dispatchers.IO)

    private companion object {
        const val PageSize = 20
        const val JumpThreshold = 1
        const val SpecialFormStartingId = 10000
    }
}