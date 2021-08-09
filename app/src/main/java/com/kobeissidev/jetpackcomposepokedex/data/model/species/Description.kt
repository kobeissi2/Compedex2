package com.kobeissidev.jetpackcomposepokedex.data.model.species

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Description(
    val description: String? = null,
    val language: Language? = null
) : Parcelable
