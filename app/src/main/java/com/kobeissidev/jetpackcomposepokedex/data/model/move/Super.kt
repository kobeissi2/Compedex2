package com.kobeissidev.jetpackcomposepokedex.data.model.move

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Super(
    @Json(name = "use_after")
    val useAfter: String? = null,
    @Json(name = "use_before")
    val useBefore: String? = null
) : Parcelable