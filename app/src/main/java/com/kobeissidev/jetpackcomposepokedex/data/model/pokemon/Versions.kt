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
data class Versions(
    @Json(name = "generation-i") val generationI: GenerationI? = null,
    @Json(name = "generation-ii") val generationII: GenerationIi? = null,
    @Json(name = "generation-iii") val generationIII: GenerationIii? = null,
    @Json(name = "generation-iv") val generationIV: GenerationIv? = null,
    @Json(name = "generation-v") val generationV: GenerationV? = null,
    @Json(name = "generation-vi") val generationVI: GenerationVi? = null,
    @Json(name = "generation-vii") val generationVII: GenerationVii? = null,
    @Json(name = "generation-viii") val generationVIII: GenerationViii? = null
) : Parcelable