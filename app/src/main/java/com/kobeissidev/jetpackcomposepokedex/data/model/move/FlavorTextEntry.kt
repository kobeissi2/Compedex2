package com.kobeissidev.jetpackcomposepokedex.data.model.move

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class FlavorTextEntry(
    @Json(name = "flavor_text")
    val flavorText: String = "",
    @Json(name = "language")
    val language: Language = Language(),
    @Json(name = "version_group")
    val versionGroup: VersionGroup = VersionGroup()
) : Parcelable