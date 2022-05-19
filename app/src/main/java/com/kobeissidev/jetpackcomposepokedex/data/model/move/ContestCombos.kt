package com.kobeissidev.jetpackcomposepokedex.data.model.move

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ContestCombos(
    @Json(name = "normal")
    val normal: Normal = Normal(),
    @Json(name = "super")
    val superX: Super = Super()
) : Parcelable