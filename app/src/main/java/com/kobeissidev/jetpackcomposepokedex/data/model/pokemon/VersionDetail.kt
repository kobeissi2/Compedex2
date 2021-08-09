package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.kpstv.bindings.AutoGenerateListConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@AutoGenerateListConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class VersionDetail(
    val rarity: Int? = null,
    val version: VersionX? = null
) : Parcelable