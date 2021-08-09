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
data class Sprites(
    @Json(name = "back_default")   val backDefault: String? = null,
    @Json(name = "back_female")  val backFemale: String? = null,
    @Json(name = "back_shiny")  val backShiny: String? = null,
    @Json(name = "back_shiny_female")  val backShinyFemale: String? = null,
    @Json(name = "front_default")  val frontDefault: String? = null,
    @Json(name = "front_female")  val frontFemale: String? = null,
    @Json(name = "front_shiny")  val frontShiny: String? = null,
    @Json(name = "front_shiny_female")  val frontShinyFemale: String? = null,
    val other: Other? = null,
    val versions: Versions? = null
) : Parcelable