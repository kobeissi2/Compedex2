package com.kobeissidev.jetpackcomposepokedex.data.paging

import android.content.SharedPreferences
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.kobeissidev.jetpackcomposepokedex.data.local.PokeDatabase
import com.kobeissidev.jetpackcomposepokedex.data.model.entry.PokemonEntry
import com.kobeissidev.jetpackcomposepokedex.data.model.remotekey.RemoteKey
import com.kobeissidev.jetpackcomposepokedex.data.remote.PokeApiService
import com.kobeissidev.jetpackcomposepokedex.util.getResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Mediates the Pokemon Entry data and adds them to the database as needed.
 */
@ExperimentalPagingApi
class PokemonRemoteMediator(
    private val apiService: PokeApiService,
    private val database: PokeDatabase,
    private val sharedPreferences: SharedPreferences
) : RemoteMediator<Int, PokemonEntry>() {

    /**
     * Update paginated content when this is initialized.
     */
    //TODO: See if this should be removed
/*    override suspend fun initialize() = if (sharedPreferences.getBoolean(FirstLaunch, true)) {
        sharedPreferences.edit().putBoolean(FirstLaunch, false).apply()
        InitializeAction.LAUNCH_INITIAL_REFRESH
    } else InitializeAction.SKIP_INITIAL_REFRESH*/

    /**
     * Load the data
     */
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntry>
    ): MediatorResult {
        // Get the page requested from the state
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }
        return try {
            withContext(Dispatchers.IO) {
                val response = getResult {
                    // Fetch the current page from the API
                    apiService.getPokemonEntry(
                        limit = Limit,
                        offset = page * Limit
                    )
                }.data!!.apply {
                    // Set the id to the page just so we can keep track of it.
                    id = page
                }
                // If the next entry is empty, we know we are at the end.
                val isEndOfList = response.next.isNullOrBlank()
                // Update the database with the response.
                database.withTransaction {
                    // Create a remote key and keep track of the previous and next key.
                    val prevKey = if (page == StartingPageIndex) null else page - 1
                    val nextKey = if (isEndOfList) null else page + 1
                    val keys = RemoteKey(id = "${response.id}", prevKey = prevKey, nextKey = nextKey)
                    // Save the Pokemon entries and the remote keys in the database.
                    database.pokedexDao().insertAllRemoteKeys(keys)
                    database.pokedexDao().insertAllPokemonEntries(response)
                }
                Timber.d("Remote mediator exception successful")
                delay(500)
                MediatorResult.Success(endOfPaginationReached = isEndOfList)
            }
        } catch (exception: Exception) {
            Timber.e("Remote mediator exception thrown: $exception")
            MediatorResult.Error(exception)
        }
    }

    /**
     * Returns the data for the mediator using the state.
     * @param loadType is the action that will be performed.
     * @param state contains our keys or the position close to it.
     */
    private suspend fun getKeyPageData(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntry>
    ) = when (loadType) {
        // Returns the current key if not null otherwise return the starting page index.
        LoadType.REFRESH -> getRemoteKeyClosestToCurrentPosition(state)?.nextKey?.minus(1) ?: StartingPageIndex
        // Returns the next key if not null otherwise inform that we are at the end of the page.
        LoadType.APPEND -> getLastRemoteKey(state)?.nextKey ?: MediatorResult.Success(endOfPaginationReached = false)
        // Returns the previous key if not null otherwise inform that we are at the beginning of the page.
        LoadType.PREPEND -> getFirstRemoteKey(state)?.prevKey ?: MediatorResult.Success(endOfPaginationReached = false)
    }

    /**
     * Gets the remote key closest to the current position.
     * Credit to https://github.com/engi2nee/android-pagination-paging-3.0
     */
    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, PokemonEntry>) =
        state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { repoId ->
                database.pokedexDao().getRemoteKey(repoId)
            }
        }

    /**
     * Gets the last remote key from the state.
     * Credit to https://github.com/engi2nee/android-pagination-paging-3.0
     */
    private suspend fun getLastRemoteKey(state: PagingState<Int, PokemonEntry>) = state.pages
        .lastOrNull { it.data.isNotEmpty() }
        ?.data?.lastOrNull()
        ?.let { pokemonEntry -> database.pokedexDao().getRemoteKey(pokemonEntry.id) }

    /**
     * Gets the first remote key from the state.
     * Credit to https://github.com/engi2nee/android-pagination-paging-3.0
     */
    private suspend fun getFirstRemoteKey(state: PagingState<Int, PokemonEntry>) = state.pages
        .firstOrNull { it.data.isNotEmpty() }
        ?.data?.firstOrNull()
        ?.let { pokemonEntry -> database.pokedexDao().getRemoteKey(pokemonEntry.id) }

    private companion object {
        // API Limit on number of Pokemon Entries to fetch.
        const val Limit = 20
        const val StartingPageIndex = 0
        const val FirstLaunch = "FirstLaunch"
    }
}