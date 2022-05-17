package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Ability(
    val ability: AbilityX? = null,
    @Json(name = "is_hidden") val isHidden: Boolean? = null,
    val slot: Int? = null
) : Parcelable