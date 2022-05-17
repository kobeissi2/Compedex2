package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class GenerationIii(
    val emerald: Emerald? = null,
    @Json(name = "firered-leafgreen") val fireRedLeafGreen: FireRedLeafGreen? = null,
    @Json(name = "ruby-sapphire") val rubySapphire: RubySapphire? = null
) : Parcelable