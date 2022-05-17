package com.kobeissidev.jetpackcomposepokedex.data.model.entry

import android.os.Parcelable
import com.kobeissidev.jetpackcomposepokedex.util.extractId
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Result(
    val name: String,
    val url: String
) : Parcelable {

    val id get() = url.extractId.toInt()
}