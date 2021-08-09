package com.kobeissidev.jetpackcomposepokedex.ui.navigation

/**
 * All navigation screens are contained here.
 * When navigating with NavHost, call NavHostController.navigate(NavigationScreens.${screen}.route.
 */
sealed class NavigationScreens {
    object PokemonEntries : NavigationScreens()
    object PokemonDetails : NavigationScreens()

    /**
     * Shortcut to use the class name as the route.
     */
    val route get() = this::class.java.simpleName
}
