package com.kobeissidev.jetpackcomposepokedex.data.model.move

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Meta(
    @Json(name = "ailment")
    val ailment: Ailment = Ailment(),
    @Json(name = "ailment_chance")
    val ailmentChance: Int = 0,
    @Json(name = "category")
    val category: Category = Category(),
    @Json(name = "crit_rate")
    val critRate: Int = 0,
    @Json(name = "drain")
    val drain: Int = 0,
    @Json(name = "flinch_chance")
    val flinchChance: Int = 0,
    @Json(name = "healing")
    val healing: Int = 0,
    @Json(name = "max_hits")
    val maxHits: String? = null,
    @Json(name = "max_turns")
    val maxTurns: String? = null,
    @Json(name = "min_hits")
    val minHits: String? = null,
    @Json(name = "min_turns")
    val minTurns: String? = null,
    @Json(name = "stat_chance")
    val statChance: Int = 0
) : Parcelable