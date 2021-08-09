package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionGroup
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.composable.AutoSizeText
import com.kobeissidev.jetpackcomposepokedex.ui.composable.RippleDropdownMenuItem
import com.kobeissidev.jetpackcomposepokedex.util.removeDash

@Composable
fun MovesTab(
    pokemon: Pokemon,
    palette: Palette
) {
    val backgroundColor by remember { mutableStateOf(palette.backgroundColor.asComposeColor) }
    val bodyTextColor by remember { mutableStateOf(palette.bodyTextColor.asComposeColor) }
    val moves by remember { mutableStateOf(pokemon.moves!!) }
    val state = rememberLazyListState()
    val versions by remember {
        mutableStateOf(
            moves
                .flatMap { it.versionGroupDetails!! }
                .map { it.versionGroup!! }
                .toSet()
                .toList()
                .sortedBy { it.sortedOrder }
        )
    }
    var selectedVersionGroup by remember { mutableStateOf(versions.first()) }
    val style = MaterialTheme.typography.body2.copy(color = bodyTextColor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .background(color = backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DropDown(
            buttonBackgroundColor = pokemon.primaryPalette.backgroundColor.asComposeColor,
            buttonTextColor = pokemon.primaryPalette.titleTextColor.asComposeColor,
            versions = versions
        ) { versionGroup ->
            selectedVersionGroup = versionGroup
        }
        LazyColumn(
            modifier = Modifier.padding(all = 16.dp),
            state = state
        ) {
            moves.forEach { move ->
                val latestVersionGroup = move.versionGroupDetails?.mapNotNull {
                    if (it.versionGroup!!.name == selectedVersionGroup.name) {
                        it
                    } else null
                } ?: listOf()

                items(latestVersionGroup) { detail ->
                    Column(
                        modifier = Modifier.padding(vertical = 2.dp),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AutoSizeText(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .alpha(0.5f),
                                text = move.move!!.name!!.removeDash,
                                style = style
                            )
                            Row(  modifier = Modifier.fillMaxWidth()) {
                                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                                AutoSizeText(
                                    modifier = Modifier.alpha(0.75f),
                                    text = detail.moveLearnMethod!!.name!!.removeDash,
                                    style = style
                                )
                                detail.levelToDisplay?.let { levelToDisplay->
                                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                                AutoSizeText(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = levelToDisplay,
                                    style = style.copy(textAlign = TextAlign.End)
                                )
                            } }
                        }
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
    }
}

@Composable
private fun DropDown(
    versions: List<VersionGroup>,
    buttonBackgroundColor: Color,
    buttonTextColor: Color,
    onClick: (VersionGroup) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomEnd)
    ) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = buttonTextColor
                ),
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonBackgroundColor),
            elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
        ) {
            AutoSizeText(
                text = versions[selectedIndex].formattedName,
                style = MaterialTheme.typography.body2.copy(
                    textAlign = TextAlign.End,
                    color = buttonTextColor
                )
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(color = Color.White)
                .requiredSizeIn(maxHeight = 250.dp),
        ) {
            versions.forEachIndexed { index, move ->
                RippleDropdownMenuItem(
                    onClick = {
                        selectedIndex = index
                        onClick(move)
                        expanded = false
                    },
                    rippleColor = buttonBackgroundColor
                )
                {
                    val style = if (selectedIndex == index) {
                        MaterialTheme.typography.body2.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                    } else {
                        MaterialTheme.typography.body2.copy(
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    }
                    AutoSizeText(
                        text = move.formattedName,
                        style = style
                    )
                }
            }
        }
    }
}