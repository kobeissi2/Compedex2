package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class Other(
    @Json(name = "dream_world")  val dreamWorld: DreamWorld? = null,
    @Json(name = "official-artwork") val officialArtwork: OfficialArtwork? = null
) : Parcelable