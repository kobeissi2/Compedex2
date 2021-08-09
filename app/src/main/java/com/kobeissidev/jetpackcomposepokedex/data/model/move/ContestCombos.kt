package com.kobeissidev.jetpackcomposepokedex.data.model.move

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class ContestCombos(
    @Json(name = "normal")
    val normal: Normal = Normal(),
    @Json(name = "super")
    val superX: Super = Super()
) : Parcelable