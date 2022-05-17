package com.kobeissidev.jetpackcomposepokedex.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kobeissidev.jetpackcomposepokedex.R
import com.kobeissidev.jetpackcomposepokedex.util.CrossFadeDurationInMillis

/**
 * Creates an image using the specified drawable.
 * @param data contains the data to display.
 * @param modifier contain any decorations to be applied to the image.
 */
@ExperimentalCoilApi
@Composable
fun CrossFadeImage(
    data: Any?,
    modifier: Modifier = Modifier,
    tintColor: Color? = null,
    text: String? = null,
    textColor: Color? = null,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(horizontalAlignment = alignment) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = data)
                .crossfade(durationMillis = CrossFadeDurationInMillis)
                .placeholder(drawableResId = R.drawable.ic_pokeball)
                .build(),
            contentDescription = null,
            colorFilter = tintColor?.let { ColorFilter.tint(color = it) },
            modifier = modifier.fillMaxWidth()
        )
        AutoSizeText(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = MaterialTheme.typography.body1.copy(
                textAlign = TextAlign.Center,
                color = textColor ?: Color.Unspecified,
            )
        )
    }
}