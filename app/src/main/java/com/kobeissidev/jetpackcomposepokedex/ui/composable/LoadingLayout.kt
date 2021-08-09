package com.kobeissidev.jetpackcomposepokedex.ui.composable

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.kobeissidev.jetpackcomposepokedex.R
import com.kobeissidev.jetpackcomposepokedex.ui.screen.MainViewModel

/**
 * Loading screen that will show an image of the app logo.
 * @param orientation is used to update the size of the image depending on the orientation.
 * @param isShowImage will show the logo if true.
 */
@Composable
fun LoadingLayout(
    isShowImage: Boolean = false,
    viewModel: MainViewModel = hiltViewModel()
) {
    val orientation by viewModel.orientationFlow.collectAsState(initial = viewModel.currentOrientation)
    val widthPercentage = if (orientation == Configuration.ORIENTATION_LANDSCAPE) 0.5f else 0.75f

    Row(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.onPrimary
        )
    }
    if (isShowImage) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(fraction = widthPercentage),
                painter = rememberImagePainter(data = R.drawable.ic_pokeball),
                contentDescription = null
            )
        }
    }
}