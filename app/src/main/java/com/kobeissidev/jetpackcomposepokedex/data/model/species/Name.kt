package com.kobeissidev.jetpackcomposepokedex.data.model.species

import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Parcelize
data class Name(
    @Json(name = "language")
    val language: LanguageXX = LanguageXX(),
    @Json(name = "name")
    val name: String = ""
) : Parcelable