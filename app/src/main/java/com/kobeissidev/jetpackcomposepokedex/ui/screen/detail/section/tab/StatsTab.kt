package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section.tab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kobeissidev.jetpackcomposepokedex.R
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Stat
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.StatX
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.composable.AutoSizeText
import com.kobeissidev.jetpackcomposepokedex.ui.composable.InfoRow

@Composable
fun StatsTab(
    pokemon: Pokemon,
    palette: Palette
) {
    val titleTextColor by remember { mutableStateOf(palette.titleTextColor.asComposeColor) }
    val bodyTextColor by remember { mutableStateOf(palette.bodyTextColor.asComposeColor) }
    val totalStats = pokemon.stats!!.sumOf { it.baseStat!! }.toDouble()
    val state = rememberLazyListState()
    val stats = pokemon.stats.toMutableList().apply {
        add(Stat(baseStat = totalStats.toInt(), stat = StatX(name = stringResource(id = R.string.total))))
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state
    ) {
        items(stats) { stat ->
            InfoRow(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .padding(vertical = 4.dp),
                title = stat.nameShortened,
                titleTextColor = titleTextColor,
                bodyTextColor = bodyTextColor
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val baseStat = stat.baseStat!!
                    AutoSizeText(
                        modifier = Modifier.fillMaxWidth(0.15f),
                        text = baseStat.toString(),
                        style = MaterialTheme.typography.body1.copy(
                            color = titleTextColor,
                            textAlign = TextAlign.End
                        )
                    )
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        progress = (baseStat / totalStats).toFloat(),
                        color = titleTextColor,
                        backgroundColor = pokemon.primaryPalette.backgroundColor.asComposeColor
                    )
                }
            }
        }
    }
}