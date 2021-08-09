package com.kobeissidev.jetpackcomposepokedex.ui.composable.autocomplete

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Copied over from Github and modified it a bit.
 * Original: https://github.com/pauloaapereira/Medium_JetpackCompose_AutoCompleteSearchBar
 */
@Stable
interface AutoCompleteDesignScope {
    var boxWidthPercentage: Float
    var shouldWrapContentHeight: Boolean
    var boxMaxHeight: Dp
    var boxBorderStroke: BorderStroke
    var boxShape: Shape
}