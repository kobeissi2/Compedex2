package com.kobeissidev.jetpackcomposepokedex.data.model.species

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Name(
    @Json(name = "language")
    val language: LanguageXX = LanguageXX(),
    @Json(name = "name")
    val name: String = ""
) : Parcelable