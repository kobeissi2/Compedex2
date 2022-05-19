package com.kobeissidev.jetpackcomposepokedex.data.model.move

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Super(
    @Json(name = "use_after")
    val useAfter: String? = null,
    @Json(name = "use_before")
    val useBefore: String? = null
) : Parcelable