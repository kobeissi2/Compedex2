package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.kpstv.bindings.AutoGenerateConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@AutoGenerateConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class GenerationIii(
    val emerald: Emerald? = null,
    @Json(name = "firered-leafgreen") val fireRedLeafGreen: FireRedLeafGreen? = null,
    @Json(name = "ruby-sapphire") val rubySapphire: RubySapphire? = null
) : Parcelable