package com.kobeissidev.jetpackcomposepokedex.ui.screen.entry.section

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.LazyPagingItems
import com.kobeissidev.jetpackcomposepokedex.R
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.ui.composable.AutoSizeText
import com.kobeissidev.jetpackcomposepokedex.ui.composable.SearchLayout

/**
 * Header for the entry screen which contains the title and the search bar.
 */
@ExperimentalPagingApi
@ExperimentalAnimationApi
@Composable
internal fun EntryHeaderSection(
    navHostController: NavHostController,
    lazyPokemonEntries: LazyPagingItems<Pokemon>,
    listState: LazyListState,
    maxGridCells: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AutoSizeText(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colors.onPrimary
            )
        )
        SearchLayout(
            navHostController = navHostController,
            items = lazyPokemonEntries.snapshot().items,
            listState = listState,
            maxGridCells = maxGridCells
        )
    }
}