package com.kobeissidev.jetpackcomposepokedex.data.model.evolution

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Species(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "url")
    val url: String = ""
) : Parcelable