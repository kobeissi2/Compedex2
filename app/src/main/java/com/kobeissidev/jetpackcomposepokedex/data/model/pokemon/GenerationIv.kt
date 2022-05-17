package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class GenerationIv(
    @Json(name = "diamond-pearl") val diamondPearl: DiamondPearl? = null,
    @Json(name = "heartgold-soulsilver") val heartGoldSoulSilver: HeartGoldSoulSilver? = null,
    val platinum: Platinum? = null
) : Parcelable