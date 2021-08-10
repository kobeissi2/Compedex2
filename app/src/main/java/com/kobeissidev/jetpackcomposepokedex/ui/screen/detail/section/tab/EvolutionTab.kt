package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.MappedEvolution
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.composable.CrossFadeImage
import com.kobeissidev.jetpackcomposepokedex.ui.composable.LoadingLayout
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel
import com.kobeissidev.jetpackcomposepokedex.util.onStateChanged
import timber.log.Timber

@ExperimentalPagingApi
@ExperimentalCoilApi
@Composable
fun EvolutionTab(
    palette: Palette,
    viewModel: MainViewModel = hiltViewModel()
) {
    val backgroundColor by remember { mutableStateOf(palette.backgroundColor.asComposeColor) }
    val titleTextColor by remember { mutableStateOf(palette.titleTextColor.asComposeColor) }
    val bodyTextColor by remember { mutableStateOf(palette.bodyTextColor.asComposeColor) }
    val evolutionState by viewModel.evolutionFlow.collectAsState()

    evolutionState.onStateChanged(
        onSuccess = { evolution ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp)
                    .background(color = backgroundColor),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val mappedEvolutionList = evolution.mappedEvolutionList
                item {
                    evolution.buildBabyItemMappedEvolution(mappedEvolutionList)?.let { babyItem ->
                        RowLayout(
                            mappedEvolution = babyItem,
                            titleTextColor = titleTextColor,
                            bodyTextColor = bodyTextColor
                        )
                    }
                }
                items(mappedEvolutionList) { mappedEvolution ->
                    RowLayout(
                        mappedEvolution = mappedEvolution,
                        titleTextColor = titleTextColor,
                        bodyTextColor = bodyTextColor
                    )
                }
            }
        },
        onLoading = { LoadingLayout() },
        onFailure = { Timber.e(it) }
    )
}

@ExperimentalCoilApi
@Composable
private fun RowLayout(
    mappedEvolution: MappedEvolution,
    titleTextColor: Color,
    bodyTextColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 32.dp,
                vertical = 4.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CrossFadeImage(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .size(100.dp),
                data = mappedEvolution.fromImageUrl,
                alignment = Alignment.CenterHorizontally
            )
            Icon(
                imageVector = Icons.Outlined.ArrowForward,
                contentDescription = null,
                tint = bodyTextColor,
                modifier = Modifier.height(100.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = mappedEvolution.condition!!,
                style = MaterialTheme.typography.body2.copy(
                    color = titleTextColor,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                ),
                maxLines = Int.MAX_VALUE,
                overflow = TextOverflow.Visible
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowForward,
                contentDescription = null,
                tint = bodyTextColor,
                modifier = Modifier.height(100.dp)
            )
            CrossFadeImage(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .size(100.dp),
                data = mappedEvolution.toImageUrl,
                alignment = Alignment.CenterHorizontally
            )
        }
    }
}