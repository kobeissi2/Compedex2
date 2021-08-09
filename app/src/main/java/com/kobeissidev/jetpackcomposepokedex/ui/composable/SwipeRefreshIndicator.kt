package com.kobeissidev.jetpackcomposepokedex.ui.composable

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator as GoogleIndicator

/**
 * Custom indicator for the SwipeRefresh being used throughout the app.
 * @param state is used to pass through from the SwipeRefresh.
 * @param trigger is used to pass through from the SwipeRefresh.
 */
@Composable
fun PokemonSwipeRefreshIndicator(
    state: SwipeRefreshState,
    trigger: Dp
) {
    GoogleIndicator(
        state = state,
        refreshTriggerDistance = trigger,
        scale = true,
        backgroundColor = MaterialTheme.colors.primary
    )
}
