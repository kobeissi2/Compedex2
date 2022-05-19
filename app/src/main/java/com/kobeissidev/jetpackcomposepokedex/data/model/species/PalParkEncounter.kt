package com.kobeissidev.jetpackcomposepokedex.data.model.species

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class PalParkEncounter(
    @Json(name = "area")
    val area: Area = Area(),
    @Json(name = "base_score")
    val baseScore: Int = 0,
    @Json(name = "rate")
    val rate: Int = 0
) : Parcelable