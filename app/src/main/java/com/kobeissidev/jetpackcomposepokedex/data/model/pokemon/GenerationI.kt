package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class GenerationI(
    @Json(name = "red-blue") val redBlue: RedBlue? = null,
    val yellow: Yellow? = null
) : Parcelable