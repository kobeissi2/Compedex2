package com.kobeissidev.jetpackcomposepokedex.ui.composable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import com.kobeissidev.jetpackcomposepokedex.R
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.ui.composable.autocomplete.AutoCompleteBox
import com.kobeissidev.jetpackcomposepokedex.ui.composable.autocomplete.TextSearchBar
import com.kobeissidev.jetpackcomposepokedex.ui.navigation.NavigationScreens
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel
import com.kobeissidev.jetpackcomposepokedex.util.EmptyString
import com.kobeissidev.jetpackcomposepokedex.util.TAG
import kotlinx.coroutines.launch

@ExperimentalPagingApi
@ExperimentalAnimationApi
@Composable
fun SearchLayout(
    navHostController: NavHostController,
    items: List<Pokemon>,
    listState: LazyGridState,
    maxGridCells: Int,
    viewModel: MainViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()

    AutoCompleteBox(
        items = items,
        itemContent = { pokemon ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = pokemon.name.capitalize(Locale.current),
                    style = MaterialTheme.typography.subtitle2.copy(
                        color = MaterialTheme.colors.onPrimary
                    )
                )
            }
        }
    ) {
        var value by remember { mutableStateOf(EmptyString) }
        val focusManager = LocalFocusManager.current

        onItemSelected { pokemon ->
            viewModel.fetchPokemon(pokemon)
            value = pokemon.name
            filter(value)
            focusManager.clearFocus()
            coroutineScope.launch {
                listState.scrollToItem(pokemon.id - 1)
                navHostController.navigate(NavigationScreens.PokemonDetails.route)
            }
        }
        TextSearchBar(
            modifier = Modifier.testTag(TAG),
            value = value,
            label = stringResource(id = R.string.search_label),
            onDoneActionClick = { focusManager.clearFocus() },
            onClearClick = {
                value = ""
                filter(value)
                focusManager.clearFocus()
            },
            onFocusChanged = { focusState ->
                isSearching = focusState.isFocused
            },
            onValueChanged = { query ->
                value = query
                filter(value)
            }
        )
    }
}