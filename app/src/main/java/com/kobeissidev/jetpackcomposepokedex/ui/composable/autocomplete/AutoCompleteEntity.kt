package com.kobeissidev.jetpackcomposepokedex.ui.composable.autocomplete

import androidx.compose.runtime.Stable

/**
 * Copied over from Github and modified it a bit.
 * Original: https://github.com/pauloaapereira/Medium_JetpackCompose_AutoCompleteSearchBar
 */
@Stable
interface AutoCompleteEntity {
    fun filter(query: String): Boolean
}

