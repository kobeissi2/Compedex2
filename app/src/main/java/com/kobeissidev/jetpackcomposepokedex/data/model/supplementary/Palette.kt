package com.kobeissidev.jetpackcomposepokedex.data.model.supplementary

import android.os.Parcelable
import com.kobeissidev.jetpackcomposepokedex.util.EmptyString
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * Data class to contain all of our Pokemon's or type colors and drawables.
 * @param name is the name of the Pokemon or type to display.
 * @param backgroundColor will contain the background color extracted from the drawable using Palette.
 * @param titleTextColor will contain the title text color extracted from the drawable using Palette.
 * @param bodyTextColor will contain the body text color extracted from the drawable using Palette
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Palette(
    val name: String = EmptyString,
    var backgroundColor: Color = Color.Unspecified,
    var titleTextColor: Color = Color.Unspecified,
    var bodyTextColor: Color = Color.Unspecified,
    val isDefault: Boolean = false
) : Parcelable {

    /**
     * Checks if the PokemonPalette calling it is empty in every field except for name.
     */
    val isEmpty get() = equals(Palette(name = name))

    companion object {
        val FallbackLightPalette = Palette(
            backgroundColor = Color.DarkGray,
            titleTextColor = Color.White,
            bodyTextColor = Color.White
        )
        val FallbackDarkPalette = Palette(
            backgroundColor = Color.White,
            titleTextColor = Color.Black,
            bodyTextColor = Color.Black
        )
    }
}
