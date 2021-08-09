package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.kobeissidev.jetpackcomposepokedex.util.removeDash
import com.kpstv.bindings.AutoGenerateConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@AutoGenerateConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class VersionGroup(
    val name: String? = null,
    val url: String? = null
) : Parcelable {

    /**
     * Return the sort order by generation.
     * Not a fan of this method but API doesn't provide a method.
     */
    val sortedOrder
        get() = when (name) {
            Gen1 -> 0
            Gen1Ext -> 1
            Gen2 -> 2
            Gen2Ext -> 3
            Gen3 -> 4
            Gen3Ext -> 5
            Gen3Remake -> 6
            Gen4 -> 7
            Gen4Ext -> 8
            Gen4Remake -> 9
            Gen5 -> 10
            Gen5Ext -> 11
            Gen6 -> 12
            Gen6Remake -> 13
            Gen7 -> 14
            Gen7Ext -> 15
            Gen8 -> 16
            else -> 17
        }

    /**
     * Format the name from dashes to a more user readable format.
     */
    val formattedName
        get() = name!!.removeDash.split(" ").run {
            if (size == NoDash) {
                joinToString(" ").trim()
            } else {
                val firstHalf = take(size / 2).joinToString(" ").trim()
                val lastHalf = takeLast(size / 2).joinToString(" ").trim()
                "$firstHalf & $lastHalf"
            }
        }.uppercase()

    private companion object {
        const val NoDash = 1

        const val Gen1 = "red-blue"
        const val Gen1Ext = "yellow"
        const val Gen2 = "gold-silver"
        const val Gen2Ext = "crystal"
        const val Gen3 = "ruby-sapphire"
        const val Gen3Ext = "emerald"
        const val Gen3Remake = "firered-leafgreen"
        const val Gen4 = "diamond-pearl"
        const val Gen4Ext = "platinum"
        const val Gen4Remake = "heartgold-soulsilver"
        const val Gen5 = "black-white"
        const val Gen5Ext = "black-2-white-2"
        const val Gen6 = "x-y"
        const val Gen6Remake = "omega-ruby-alpha-sapphire"
        const val Gen7 = "sun-moon"
        const val Gen7Ext = "ultra-sun-ultra-moon"
        const val Gen8 = "sword-shield"
    }
}