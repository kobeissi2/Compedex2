package com.kobeissidev.jetpackcomposepokedex.ui.composable

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import coil.compose.rememberImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.kobeissidev.jetpackcomposepokedex.R
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel

@ExperimentalPagingApi
@Composable
fun ErrorLayout(
    viewModel: MainViewModel = hiltViewModel(),
    onRefresh: () -> Unit = {},
) {
    val orientation by viewModel.orientationFlow.collectAsState(initial = viewModel.currentOrientation)
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val scrollState = rememberScrollState()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = onRefresh,
        indicator = { state, trigger ->
            PokemonSwipeRefreshIndicator(
                state = state,
                trigger = trigger
            )
        }
    ) {
        val modifier = Modifier.fillMaxSize()

        when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> PokemonErrorLandscapeSection(
                modifier = modifier,
                scrollState = scrollState
            )
            else -> PokemonErrorPortraitSection(
                modifier = modifier,
                scrollState = scrollState
            )
        }
    }
}

@Composable
private fun PokemonErrorPortraitSection(
    modifier: Modifier = Modifier,
    scrollState: ScrollState
) {
    Column(
        modifier = modifier.verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ErrorTitleText()
        PikachuImage(imageSize = 250.dp)
        ErrorSubText()
    }
}

@Composable
private fun PokemonErrorLandscapeSection(
    modifier: Modifier = Modifier,
    scrollState: ScrollState
) {
    Row(
        modifier = modifier.verticalScroll(state = scrollState),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PikachuImage(imageSize = 300.dp)
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ErrorTitleText(modifier = Modifier.fillMaxWidth())
            ErrorSubText(modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
private fun ErrorTitleText(modifier: Modifier = Modifier) {
    AutoSizeText(
        modifier = modifier,
        text = stringResource(id = R.string.failed_to_load),
        style = MaterialTheme.typography.h4.copy(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colors.onPrimary
        )
    )
}

@Composable
private fun PikachuImage(imageSize: Dp) {
    Image(
        painter = rememberImagePainter(data = R.drawable.ic_pikachu),
        contentDescription = null,
        modifier = Modifier.size(imageSize)
    )
}

@Composable
private fun ErrorSubText(modifier: Modifier = Modifier) {
    AutoSizeText(
        modifier = modifier.fillMaxWidth(),
        text = stringResource(id = R.string.internet_required),
        style = MaterialTheme.typography.body1.copy(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onPrimary
        )
    )
    AutoSizeText(
        modifier = modifier.fillMaxWidth(),
        text = stringResource(id = R.string.try_again),
        style = MaterialTheme.typography.body1.copy(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onPrimary
        )
    )
}