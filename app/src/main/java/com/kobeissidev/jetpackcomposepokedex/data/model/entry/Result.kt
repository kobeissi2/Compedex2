package com.kobeissidev.jetpackcomposepokedex.data.model.entry

import android.os.Parcelable
import com.kobeissidev.jetpackcomposepokedex.util.extractId
import com.kpstv.bindings.AutoGenerateListConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@AutoGenerateListConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class Result(
    val name: String,
    val url: String
) : Parcelable {

    val id get() = url.extractId.toInt()
}