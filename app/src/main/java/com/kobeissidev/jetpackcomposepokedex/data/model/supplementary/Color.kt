package com.kobeissidev.jetpackcomposepokedex.data.model.supplementary

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import androidx.compose.ui.graphics.Color as ComposeColor

/***
 * Wrapper for Color class as Moshi doesn't like Platform classes without custom adapters.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Color(
    val red: Float,
    val green: Float,
    val blue: Float
) : Parcelable {

    /**
     *  Returns true if the fields are empty.
     */
    val isEmpty
        get() = Color(
            red = red,
            green = green,
            blue = blue
        ) == Unspecified

    /**
     * Converts this wrapper class into the Color class.
     */
    val asComposeColor
        get() = ComposeColor(
            red = red,
            green = green,
            blue = blue
        )

    companion object {
        /**
         * Predefined colors to use for fallback palettes.
         */
        val Unspecified = fromComposeColor(ComposeColor.Unspecified)
        val DarkGray = fromComposeColor(ComposeColor.DarkGray)
        val White = fromComposeColor(ComposeColor.White)
        val Black = fromComposeColor(ComposeColor.Black)

        /**
         * Converts a Color object into this wrapper.
         * @param composeColor is the color from the Compose Color class.
         */
        fun fromComposeColor(composeColor: ComposeColor) = composeColor.run {
            Color(
                red = red,
                green = green,
                blue = blue
            )
        }

        /**
         * Converts a Color object into this wrapper.
         * @param colorRgb is the color rgb value to wrap.
         */
        fun fromComposeColor(colorRgb: Int) = ComposeColor(color = colorRgb).run {
            Color(
                red = red,
                green = green,
                blue = blue
            )
        }
    }
}