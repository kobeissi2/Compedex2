package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section.tab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import com.kobeissidev.jetpackcomposepokedex.R
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.species.Species
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.composable.AutoSizeText
import com.kobeissidev.jetpackcomposepokedex.ui.composable.InfoRow
import com.kobeissidev.jetpackcomposepokedex.ui.composable.LoadingLayout
import com.kobeissidev.jetpackcomposepokedex.ui.composable.RoundedButton
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel
import com.kobeissidev.jetpackcomposepokedex.util.decimeterAsString
import com.kobeissidev.jetpackcomposepokedex.util.hectogramAsString
import com.kobeissidev.jetpackcomposepokedex.util.OnStateChanged
import com.kobeissidev.jetpackcomposepokedex.util.removeDash
import timber.log.Timber

@ExperimentalPagingApi
@Composable
internal fun AboutTab(
    pokemon: Pokemon,
    palette: Palette,
    viewModel: MainViewModel = hiltViewModel()
) {
    val backgroundColor by remember { mutableStateOf(palette.backgroundColor.asComposeColor) }
    val titleTextColor by remember { mutableStateOf(palette.titleTextColor.asComposeColor) }
    val bodyTextColor by remember { mutableStateOf(palette.bodyTextColor.asComposeColor) }
    val speciesState by viewModel.speciesFlow.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 32.dp)
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        speciesState.OnStateChanged(
            onSuccess = { species ->
                val abilities = pokemon.abilities!!

                InfoRow(
                    titleRes = R.string.height,
                    value = decimeterAsString(pokemon.height!!),
                    titleTextColor = titleTextColor,
                    bodyTextColor = bodyTextColor
                )
                InfoRow(
                    titleRes = R.string.weight,
                    value = hectogramAsString(pokemon.weight!!),
                    titleTextColor = titleTextColor,
                    bodyTextColor = bodyTextColor
                )
                InfoRow(
                    titleRes = R.string.abilities,
                    value = abilities.filterNot { it.isHidden!! }.map { it.ability!!.name!! }.removeDash,
                    titleTextColor = titleTextColor,
                    bodyTextColor = bodyTextColor
                )
                val hiddenAbility = abilities.filter { it.isHidden!! }
                if (hiddenAbility.isNotEmpty()) {
                    InfoRow(
                        titleRes = R.string.hidden_ability,
                        value = hiddenAbility.map { it.ability!!.name!! }.removeDash,
                        titleTextColor = titleTextColor,
                        bodyTextColor = bodyTextColor
                    )
                }
                InfoRow(
                    titleRes = R.string.base_happiness,
                    value = species.baseHappiness.toString(),
                    titleTextColor = titleTextColor,
                    bodyTextColor = bodyTextColor
                )
                InfoRow(
                    titleRes = R.string.capture_rate,
                    value = species.captureRate.toString(),
                    titleTextColor = titleTextColor,
                    bodyTextColor = bodyTextColor
                )
                InfoRow(
                    titleRes = R.string.color,
                    value = species.color.name,
                    titleTextColor = titleTextColor,
                    bodyTextColor = bodyTextColor
                )
                if (species.hasGender) {
                    GenderRow(
                        titleTextColor = titleTextColor,
                        bodyTextColor = bodyTextColor,
                        species = species
                    )
                    InfoRow(
                        titleRes = R.string.hatch_counter,
                        value = species.hatchCounter.toString(),
                        titleTextColor = titleTextColor,
                        bodyTextColor = bodyTextColor
                    )
                }
                EggGroupRow(
                    backgroundColor = backgroundColor,
                    titleTextColor = titleTextColor,
                    bodyTextColor = bodyTextColor,
                    species = species
                )

            },
            onLoading = { LoadingLayout() },
            onFailure = { message -> Timber.e(message) }
        )
    }
}

@Composable
private fun GenderRow(
    titleTextColor: Color,
    bodyTextColor: Color,
    species: Species
) {
    InfoRow(
        titleRes = R.string.gender,
        titleTextColor = titleTextColor,
        bodyTextColor = bodyTextColor
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    modifier = Modifier.size(size = 14.dp),
                    imageVector = Icons.Filled.Male,
                    contentDescription = null,
                    tint = titleTextColor,
                )
                AutoSizeText(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "${species.maleGenderRate}%",
                    style = MaterialTheme.typography.body1.copy(color = titleTextColor)
                )
            }
            Spacer(modifier = Modifier.padding(start = 4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    modifier = Modifier.size(size = 14.dp),
                    imageVector = Icons.Filled.Female,
                    contentDescription = null,
                    tint = titleTextColor
                )
                AutoSizeText(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "${species.femaleGenderRate}%",
                    style = MaterialTheme.typography.body1.copy(color = titleTextColor)
                )
            }
        }
    }
}

@Composable
private fun EggGroupRow(
    backgroundColor: Color,
    titleTextColor: Color,
    bodyTextColor: Color,
    species: Species
) {
    InfoRow(
        titleRes = R.string.egg_group,
        titleTextColor = titleTextColor,
        bodyTextColor = bodyTextColor
    ) {
        LazyRow {
            items(species.eggGroups) { eggGroup ->
                RoundedButton(
                    textColor = backgroundColor,
                    borderColor = bodyTextColor,
                    text = eggGroup.name.removeDash,
                    style = MaterialTheme.typography.body2,
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = backgroundColor,
                        backgroundColor = bodyTextColor
                    )
                )
            }
        }
    }
}