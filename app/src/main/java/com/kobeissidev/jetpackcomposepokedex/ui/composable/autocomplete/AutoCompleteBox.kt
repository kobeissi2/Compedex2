package com.kobeissidev.jetpackcomposepokedex.ui.composable.autocomplete

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Copied over from Github and modified it a bit.
 * Original: https://github.com/pauloaapereira/Medium_JetpackCompose_AutoCompleteSearchBar
 */
@ExperimentalAnimationApi
@Composable
fun <T : AutoCompleteEntity> AutoCompleteBox(
    items: List<T>,
    itemContent: @Composable (T) -> Unit,
    content: @Composable AutoCompleteScope<T>.() -> Unit
) {
    val color = MaterialTheme.colors.onPrimary
    val autoCompleteState = remember {
        AutoCompleteState(
            startItems = items,
            color = color
        )
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        autoCompleteState.content()
        AnimatedVisibility(visible = autoCompleteState.isSearching) {
            LazyColumn(
                modifier = Modifier.autoComplete(autoCompleteState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(autoCompleteState.filteredItems) { item ->
                    Box(modifier = Modifier.clickable { autoCompleteState.selectItem(item) }) {
                        itemContent(item)
                    }
                }
            }
        }
    }
}