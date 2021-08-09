package com.kobeissidev.jetpackcomposepokedex.data.model.evolution

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Chain(
    @Json(name = "evolution_details")
    val evolutionDetails: List<EvolutionDetail>? = listOf(),
    @Json(name = "evolves_to")
    val evolvesTo: List<EvolvesTo>? = listOf(),
    @Json(name = "is_baby")
    val isBaby: Boolean = false,
    @Json(name = "species")
    val species: Species? = Species()
) : Parcelable