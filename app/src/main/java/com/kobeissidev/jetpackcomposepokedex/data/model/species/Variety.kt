package com.kobeissidev.jetpackcomposepokedex.data.model.species

import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Parcelize
data class Variety(
    @Json(name = "is_default")
    val isDefault: Boolean = false,
    @Json(name = "pokemon")
    val pokemon: Pokemon? = null
) : Parcelable