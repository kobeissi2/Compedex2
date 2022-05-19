package com.kobeissidev.jetpackcomposepokedex.data.model.move

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

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