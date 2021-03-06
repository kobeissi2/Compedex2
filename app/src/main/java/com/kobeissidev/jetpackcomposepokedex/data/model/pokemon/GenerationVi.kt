package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class GenerationVi(
    @Json(name = "omegaruby-alphasapphire") val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphire? = null,
    @Json(name = "x-y") val xY: XY? = null
) : Parcelable