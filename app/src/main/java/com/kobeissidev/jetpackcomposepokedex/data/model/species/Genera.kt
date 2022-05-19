package com.kobeissidev.jetpackcomposepokedex.data.model.species

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Genera(
    @Json(name = "genus")
    val genus: String = "",
    @Json(name = "language")
    val language: LanguageX = LanguageX()
) : Parcelable