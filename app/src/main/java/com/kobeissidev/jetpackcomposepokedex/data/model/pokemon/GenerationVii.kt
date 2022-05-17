package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class GenerationVii(
    val icons: Icons? = null,
    @Json(name = "ultra-sun-ultra-moon") val ultraSunUltraMoon: UltraSunUltraMoon? = null
) : Parcelable