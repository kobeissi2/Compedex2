package com.kobeissidev.jetpackcomposepokedex.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.DetailScreen
import com.kobeissidev.jetpackcomposepokedex.ui.screen.entry.EntriesScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Default screen which handles the navigation and starts with the PokemonEntries screen.
 */
@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalPagingApi
@ExperimentalFoundationApi
@Composable
fun MainNavigationScreen() {
    // Remember this navController here so we can reuse the same instance among all screens.
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController, startDestination = NavigationScreens.PokemonEntries.route) {
        composable(NavigationScreens.PokemonEntries.route) { EntriesScreen(navController) }
        composable(NavigationScreens.PokemonDetails.route) { DetailScreen() }
    }

}