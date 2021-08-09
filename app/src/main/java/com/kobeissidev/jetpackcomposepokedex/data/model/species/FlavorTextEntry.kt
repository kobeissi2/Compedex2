package com.kobeissidev.jetpackcomposepokedex.data.model.species

import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Parcelize
data class FlavorTextEntry(
    @Json(name = "flavor_text")
    val flavorText: String = "",
    @Json(name = "language")
    val language: Language = Language(),
    @Json(name = "version")
    val version: Version = Version()
) : Parcelable