package com.kobeissidev.jetpackcomposepokedex.ui.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp

@Composable
fun InfoRow(
    titleTextColor: Color,
    bodyTextColor: Color,
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int = -1,
    title: String? = null,
    value: String = "",
    content: @Composable () -> Unit = {
        AutoSizeText(
            text = value.capitalize(Locale.current),
            style = MaterialTheme.typography.body1.copy(color = bodyTextColor)
        )
    }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AutoSizeText(
            modifier = modifier.alpha(0.5f),
            text = title ?: stringResource(id = titleRes),
            style = MaterialTheme.typography.body1.copy(color = titleTextColor)
        )
        content()
    }
}