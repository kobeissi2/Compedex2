package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.composable.AutoSizeText
import com.kobeissidev.jetpackcomposepokedex.ui.composable.RoundedButton

@Composable
internal fun DetailHeaderSection(
    pokemon: Pokemon,
    palette: Palette
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 32.dp)
    ) {
        AutoSizeText(
            modifier = Modifier.fillMaxWidth(),
            text = pokemon.name,
            style = MaterialTheme.typography.h4.copy(
                color = pokemon.primaryPalette.titleTextColor.asComposeColor,
                fontWeight = FontWeight.ExtraBold
            )
        )
        AutoSizeText(
            modifier = Modifier.fillMaxWidth(),
            text = pokemon.number,
            style = MaterialTheme.typography.h6.copy(
                color = pokemon.primaryPalette.bodyTextColor.asComposeColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
            )
        )
        LazyRow {
            items(pokemon.types!!) {
                RoundedButton(
                    textColor = palette.bodyTextColor.asComposeColor,
                    text = it.type!!.name!!.uppercase(),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = palette.bodyTextColor.asComposeColor,
                        backgroundColor = palette.backgroundColor.asComposeColor
                    )
                )
            }
        }
    }
}