package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.composable.LoadingLayout
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel
import com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section.tab.*
import com.kobeissidev.jetpackcomposepokedex.util.onStateChanged
import timber.log.Timber

@ExperimentalPagingApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
internal fun InfoCard(
    pokemon: Pokemon,
    palette: Palette,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val speciesResult by viewModel.speciesFlow.collectAsState()
    val evolutionResult by viewModel.evolutionFlow.collectAsState()
    // Add all tabs that are required.
    val tabs = mutableListOf<Pair<Tabs, @Composable () -> Unit>>().apply {
        speciesResult.onStateChanged(onLoading = { LoadingLayout() }) {
            add(Tabs.About to { AboutTab(pokemon = pokemon, palette = palette) })
        }
        add(Tabs.BaseStats to { StatsTab(pokemon = pokemon, palette = palette) })
        evolutionResult.onStateChanged(
            onLoading = { LoadingLayout() },
            onFailure = { Timber.e(it) }
        ) { evolution ->
            if (!evolution.chain.evolvesTo.isNullOrEmpty()) {
                add(Tabs.Evolution to { EvolutionTab(palette = palette) })
            }
        }
        if (!pokemon.moves.isNullOrEmpty()) {
            add(Tabs.Moves to { MovesTab(pokemon = pokemon, palette = palette) })
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = 16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 20.dp)),
            backgroundColor = palette.backgroundColor.asComposeColor,
        ) {
            InfoTabLayout(
                backgroundColor = palette.backgroundColor.asComposeColor,
                textColor = palette.titleTextColor.asComposeColor,
                tabs = tabs.toTypedArray()
            )
        }
    }
}