package com.kobeissidev.jetpackcomposepokedex.ui.screen.entry.section

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.ui.composable.PokemonCard
import com.kobeissidev.jetpackcomposepokedex.ui.composable.PokemonSwipeRefreshIndicator
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel
import com.kobeissidev.jetpackcomposepokedex.util.GridCellsCount
import com.kobeissidev.jetpackcomposepokedex.util.GridCellsLandscapeCount
import com.kobeissidev.jetpackcomposepokedex.util.items

/**
 * Section of the app that contains all of the Pokemon cards and the title.
 * Layout is adaptive and works on both portrait and landscape.
 * @param navHostController is used for navigating to the PokemonDetailsScreen when a Pokemon is tapped on.
 * @param lazyPokemonEntries contains all of the Pokemon minor details.
 * @param viewModel contains our refreshing state.
 * @param listState contains our scroll state.
 * @param isError checks if the state of the paging library has an error.
 */
@ExperimentalPagingApi
@ExperimentalAnimationApi
@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
internal fun DataSection(
    navHostController: NavHostController,
    lazyPokemonEntries: LazyPagingItems<Pokemon>,
    viewModel: MainViewModel = hiltViewModel(),
    listState: LazyGridState = rememberLazyGridState(),
    isError: Boolean = lazyPokemonEntries.loadState.refresh is LoadState.Error
) {
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val orientation by viewModel.orientationFlow.collectAsState(initial = viewModel.currentOrientation)
    val maxGridCells = when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> GridCellsLandscapeCount
        else -> GridCellsCount
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = { lazyPokemonEntries.refresh() },
        indicator = { state, trigger ->
            PokemonSwipeRefreshIndicator(
                state = state,
                trigger = trigger
            )
        }
    ) {
        Column {
            EntryHeaderSection(
                navHostController = navHostController,
                lazyPokemonEntries = lazyPokemonEntries,
                listState = listState
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = maxGridCells),
                state = listState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(all = 8.dp),
            ) {
                items(lazyPokemonEntries) { pokemon ->
                    PokemonCard(
                        navHostController = navHostController,
                        viewModel = viewModel,
                        pokemon = pokemon,
                        isScrolling = listState.isScrollInProgress,
                        isError = isError
                    )
                }
            }
        }
    }
}