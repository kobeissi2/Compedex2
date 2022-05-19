package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Move(
    val move: MoveX? = null,
    @Json(name = "version_group_details") val versionGroupDetails: List<VersionGroupDetail>? = null
) : Parcelable