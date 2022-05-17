package com.kobeissidev.jetpackcomposepokedex.ui.screen.entry

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.kobeissidev.jetpackcomposepokedex.ui.composable.ErrorLayout
import com.kobeissidev.jetpackcomposepokedex.ui.composable.LoadingLayout
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel
import com.kobeissidev.jetpackcomposepokedex.ui.screen.entry.section.DataSection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay

/**
 * Main section of the app. Displays all of the Pokemon Entries.
 * @param navHostController is used for navigating to the PokemonDetailsScreen when a Pokemon is tapped on.
 * @param viewModel contains our data and logic.
 */
@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun EntriesScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val lazyPokemonEntries = viewModel.pokemonPagingFlow.collectAsLazyPagingItems()
    val errorState by viewModel.isError.collectAsState()
    val isListEmpty = lazyPokemonEntries.itemCount == 0
    val isError = (lazyPokemonEntries.loadState.refresh is LoadState.Error || errorState) && isListEmpty
    var isReady by remember { mutableStateOf(false) }
    val isLoading = lazyPokemonEntries.loadState.refresh is LoadState.Loading ||
            (lazyPokemonEntries.loadState.refresh is LoadState.NotLoading && !isReady)

    // Prevents LazyPagingItems from loading in too quickly which randomly triggers the first page not to load properly.
    LaunchedEffect(key1 = isError) {
        delay(1000)
        isReady = !isError
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        if (isLoading || isError || !isReady) {
            LoadingLayout(isShowImage = (isListEmpty && !isError) || !isReady)
        }
        when {
            isListEmpty && isError -> {
                LoadingLayout(isShowImage = false)
                ErrorLayout(onRefresh = { viewModel.onErrorRetry(lazyPokemonEntries) })
            }
            !isListEmpty -> {
                if (isReady) {
                    DataSection(
                        lazyPokemonEntries = lazyPokemonEntries,
                        navHostController = navHostController
                    )
                } else lazyPokemonEntries.refresh()
            }
        }
    }
}