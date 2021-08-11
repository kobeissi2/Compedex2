package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.ui.composable.CrossFadeImage

@ExperimentalCoilApi
@Composable
internal fun ArtworkSection(pokemon: Pokemon) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CrossFadeImage(
            modifier = Modifier.size(250.dp),
            data = pokemon.imageUrl
        )
    }
}