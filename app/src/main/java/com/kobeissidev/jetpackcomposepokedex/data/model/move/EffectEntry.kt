package com.kobeissidev.jetpackcomposepokedex.data.model.move

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class EffectEntry(
    @Json(name = "effect")
    val effect: String = "",
    @Json(name = "language")
    val language: Language = Language(),
    @Json(name = "short_effect")
    val shortEffect: String = ""
) : Parcelable