package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.kpstv.bindings.AutoGenerateConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@AutoGenerateConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class Crystal(
    @Json(name = "back_default") val backDefault: String? = null,
    @Json(name = "back_gray") val backGray: String? = null,
    @Json(name = "front_default") val frontDefault: String? = null,
    @Json(name = "front_gray") val frontGray: String? = null
) : Parcelable