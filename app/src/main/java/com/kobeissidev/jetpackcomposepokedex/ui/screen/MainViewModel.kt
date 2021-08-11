package com.kobeissidev.jetpackcomposepokedex.ui.screen

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import androidx.paging.compose.LazyPagingItems
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.repository.PokedexRepository
import com.kobeissidev.jetpackcomposepokedex.util.isOnline
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokedexRepository,
    private val sharedPreferences: SharedPreferences,
    @ApplicationContext context: Context
) : AndroidViewModel(context as Application) {

    /**
     * Expose the Pokemon Paging Flow to the View
     */
    @ExperimentalPagingApi
    val pokemonPagingFlow = repository.pokemonPagingFlow
        .cachedIn(viewModelScope)
        .flowOn(Dispatchers.IO)
        .onStart {
            isError.emit(!context.isOnline.also { isError ->
                if (isError) sharedPreferences.edit().clear().apply()
            })
        }

    /**
     * Flow for keeping track of the Pokemon fetch result.
     */
    val fetchingStatusFlow = repository.fetchingStatusFlow.asStateFlow()

    /**
     * Flow for keeping track of the Pokemon species fetch result.
     */
    val speciesFlow = repository.speciesFlow.asStateFlow()

    /**
     * Flow for keeping track of the Pokemon evolution chain fetch result.
     */
    val evolutionFlow = repository.evolutionFlow.asStateFlow()

    /**
     * Current orientation using the Application Context.
     */
    val currentOrientation get() = getApplication<Application>().resources.configuration.orientation

    /**
     * Flow for the orientation changes.
     */
    val orientationFlow = snapshotFlow { currentOrientation }.flowOn(Dispatchers.IO)

    /**
     * State for if the layout is refreshing
     */
    val isRefreshing = MutableStateFlow(false)

    /**
     * State for if the layout is an error
     */
    val isError = MutableStateFlow(false)

    /**
     * List of disposables of the ImageLoader.
     */
    private val imageRequestList = repository.imageRequestList

    /**
     * Disposes all image requests on cleared.
     */
    override fun onCleared() {
        imageRequestList.forEach { disposable -> disposable.dispose() }
        imageRequestList.clear()
        viewModelScope.cancel()
        super.onCleared()
    }

    /**
     * Get the Pokemon using the Pokemon id
     * @param pokemon is the base object that we'll use to fetch the remaining data.
     */
    fun fetchPokemon(pokemon: Pokemon) = viewModelScope.launch { repository.fetchPokemon(pokemon) }

    /**
     * Attempt to re-fetch the data if an internet connection if available.
     */
    fun refetchPokemon() = viewModelScope.launch { repository.refetchPokemon(getApplication()) }

    /**
     * Reset the error flow on refresh at the error screen
     */
    fun onErrorRetry(lazyPokemonEntries: LazyPagingItems<Pokemon>) {
        viewModelScope.launch {
            delay(1000)
            lazyPokemonEntries.retry()
            isError.emit(!getApplication<Application>().isOnline)
        }
    }
}