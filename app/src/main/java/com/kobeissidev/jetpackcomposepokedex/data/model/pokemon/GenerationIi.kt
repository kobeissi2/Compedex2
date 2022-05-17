package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class GenerationIi(
    val crystal: Crystal? = null,
    val gold: Gold? = null,
    val silver: Silver? = null
) : Parcelable