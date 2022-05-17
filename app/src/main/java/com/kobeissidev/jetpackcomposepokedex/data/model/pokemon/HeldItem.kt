package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class HeldItem(
    val item: Item? = null,
    val versionDetails: List<VersionDetail>? = null
) : Parcelable