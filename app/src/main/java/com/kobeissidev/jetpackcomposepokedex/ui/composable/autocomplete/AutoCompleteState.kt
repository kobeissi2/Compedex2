package com.kobeissidev.jetpackcomposepokedex.ui.composable.autocomplete

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Copied over from Github and modified it a bit.
 * Original: https://github.com/pauloaapereira/Medium_JetpackCompose_AutoCompleteSearchBar
 */
class AutoCompleteState<T : AutoCompleteEntity>(private val startItems: List<T>, val color: Color) :
    AutoCompleteScope<T> {
    private var onItemSelectedBlock: ((T) -> Unit)? = null

    fun selectItem(item: T) =onItemSelectedBlock?.invoke(item)

    var filteredItems by mutableStateOf(startItems)
    override var isSearching by mutableStateOf(false)
    override var boxWidthPercentage by mutableStateOf(.89f)
    override var shouldWrapContentHeight by mutableStateOf(false)
    override var boxMaxHeight: Dp by mutableStateOf(TextFieldDefaults.MinHeight * 3)
    override var boxBorderStroke by mutableStateOf(BorderStroke(2.dp, color))
    override var boxShape: Shape by mutableStateOf(RoundedCornerShape(8.dp))

    override fun filter(query: String) {
        filteredItems = startItems.filter { entity ->
            entity.filter(query)
        }
    }

    override fun onItemSelected(block: ((T) -> Unit)) {
        onItemSelectedBlock = block
    }
}