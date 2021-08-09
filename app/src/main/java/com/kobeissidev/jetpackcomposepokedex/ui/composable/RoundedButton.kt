package com.kobeissidev.jetpackcomposepokedex.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(
    text: String,
    textColor: Color,
    borderColor: Color = textColor,
    colors : ButtonColors = ButtonDefaults.outlinedButtonColors(),
    style: TextStyle = MaterialTheme.typography.body1
) {
    OutlinedButton(
        onClick = { },
        border = BorderStroke(1.dp, borderColor),
        shape = RoundedCornerShape(50),
        colors = colors,
        modifier = Modifier
            .padding(horizontal = 2.dp)
            .height(34.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
    ) {
        AutoSizeText(
            text = text.uppercase(),
            style = style.copy(color = textColor)
        )
    }
}