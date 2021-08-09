package com.kobeissidev.jetpackcomposepokedex.data.model.evolution

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class EvolvesTo(
    @Json(name = "evolution_details")
    val evolutionDetailList: List<EvolutionDetail>? = listOf(),
    @Json(name = "evolves_to")
    val evolvesTo: List<EvolvesTo>? = listOf(),
    @Json(name = "is_baby")
    val isBaby: Boolean = false,
    @Json(name = "species")
    val species: Species = Species()
) : Parcelable {

    val evolutionDetails
        get() = when (species.name) {
            Feebas, Milotic -> evolutionDetailList?.dropLast(1)
            else -> evolutionDetailList
        }

    private companion object {
        // Special cases
        // API returns one of the same conditions twice for some reason.
        const val Feebas = "feebas"
        const val Milotic = "milotic"
    }
}