package com.kobeissidev.jetpackcomposepokedex.data.model.supplementary

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Parcelable
import androidx.room.ColumnInfo
import com.kobeissidev.jetpackcomposepokedex.util.EmptyString
import com.kpstv.bindings.AutoGenerateListConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * Data class to contain all of our Pokemon's or type colors and drawables.
 * @param name is the name of the Pokemon or type to display.
 * @param backgroundColor will contain the background color extracted from the drawable using Palette.
 * @param titleTextColor will contain the title text color extracted from the drawable using Palette.
 * @param bodyTextColor will contain the body text color extracted from the drawable using Palette.
 * @param drawableArray is the sprite as a byte array to save into the DB. It is usually not recommended to do so but the sprites are tiny.
 */
@AutoGenerateListConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class Palette(
    val name: String = EmptyString,
    var backgroundColor: Color = Color.Unspecified,
    var titleTextColor: Color = Color.Unspecified,
    var bodyTextColor: Color = Color.Unspecified,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var drawableArray: ByteArray = byteArrayOf(),
    val isDefault: Boolean = false
) : Parcelable {

    /**
     * Checks if the PokemonPalette calling it is empty in every field except for name.
     */
    val isEmpty get() = equals(Palette(name = name))

    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false
        other !is Palette -> false
        name != other.name -> false
        backgroundColor != other.backgroundColor -> false
        titleTextColor != other.titleTextColor -> false
        bodyTextColor != other.bodyTextColor -> false
        !drawableArray.contentEquals(other.drawableArray) -> false
        else -> true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + backgroundColor.hashCode()
        result = 31 * result + titleTextColor.hashCode()
        result = 31 * result + bodyTextColor.hashCode()
        result = 31 * result + drawableArray.contentHashCode()
        return result
    }

    /**
     * Builds a BitmapDrawable from the drawableArray.
     * @param context is required to access resources.
     */
    fun getDrawable(context: Context) = BitmapDrawable(
        context.resources,
        BitmapFactory.decodeByteArray(drawableArray, 0, drawableArray.size)
    )

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
