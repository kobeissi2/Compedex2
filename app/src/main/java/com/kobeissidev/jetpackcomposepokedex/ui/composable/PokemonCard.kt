package com.kobeissidev.jetpackcomposepokedex.ui.composable

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.navigation.NavigationScreens
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel

/**
 * Pokemon Card that displays the name, number and dominant color for the species.
 * @param navHostController is used for navigating to the PokemonDetailsScreen when a Pokemon is tapped on.
 * @param viewModel will be used to fetch the complete Pokemon details for the detail screen.
 * @param pokemon contains the minor Pokemon details we'll be using for displaying.
 * @param isScrolling will notify when the view is scrolling. It is currently used to hide the images as you scroll.
 * @param isError checks if the state of the paging library has an error.
 * @param palette contains our palette colors for the UI.
 */
@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun PokemonCard(
    navHostController: NavHostController,
    viewModel: MainViewModel,
    pokemon: Pokemon,
    isScrolling: Boolean,
    isError: Boolean,
    palette: Palette = pokemon.primaryPalette,
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {
    val pokemonPalette by remember {
        mutableStateOf(
            // If we couldn't build the palette information before the error occurred, default to the fallback palette.
            if (isError && palette.backgroundColor.isEmpty) {
                if (isDarkTheme) {
                    Palette.FallbackDarkPalette
                } else Palette.FallbackLightPalette
            } else pokemon.primaryPalette
        )
    }

    if (!pokemonPalette.backgroundColor.isEmpty) {
        Card(
            backgroundColor = pokemonPalette.backgroundColor.asComposeColor,
            onClick = {
                viewModel.fetchPokemon(pokemon)
                navHostController.navigate(NavigationScreens.PokemonDetails.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 125.dp)
                .padding(all = 6.dp)
                .clip(RoundedCornerShape(percent = 20))
                .shadow(elevation = 10.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                AutoSizeText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.22f)
                        .padding(
                            start = 12.dp,
                            top = 4.dp
                        ),
                    text = pokemon.name,
                    style = MaterialTheme.typography.subtitle2.copy(
                        color = pokemonPalette.titleTextColor.asComposeColor,
                        fontWeight = FontWeight.Bold
                    )
                )
                AutoSizeText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.2f)
                        .padding(start = 12.dp),
                    text = pokemon.number,
                    style = MaterialTheme.typography.subtitle2.copy(
                        color = pokemonPalette.bodyTextColor.asComposeColor,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                // Don't bother rendering the image if we don't have data or are scrolling.
                // Scrolling recomposes and triggers the image to recompose which doesn't look great.
                if (pokemonPalette.drawableArray.isNotEmpty() && !isScrolling) {
                    CrossFadeImage(
                        data = pokemonPalette.getDrawable(LocalContext.current),
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}