package com.kobeissidev.jetpackcomposepokedex.data.model.species

import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Parcelize
data class Genera(
    @Json(name = "genus")
    val genus: String = "",
    @Json(name = "language")
    val language: LanguageX = LanguageX()
) : Parcelable