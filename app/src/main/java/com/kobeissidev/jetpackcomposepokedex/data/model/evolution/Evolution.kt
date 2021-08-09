package com.kobeissidev.jetpackcomposepokedex.data.model.evolution

import android.os.Parcelable
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.MappedEvolution
import com.kobeissidev.jetpackcomposepokedex.util.NewLine
import com.kobeissidev.jetpackcomposepokedex.util.extractId
import com.kobeissidev.jetpackcomposepokedex.util.imageUrl
import com.kobeissidev.jetpackcomposepokedex.util.removeDash
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Evolution(
    @Json(name = "baby_trigger_item")
    val babyTriggerItem: Item? = null,
    @Json(name = "chain")
    val chain: Chain = Chain(),
    @Json(name = "id")
    val id: Int = 0
) : Parcelable {

    val mappedEvolutionList: List<MappedEvolution>
        get() {
            var currentSpecies = chain.species
            var evolveTo = chain.evolvesTo
            val mappedList = mutableListOf<MappedEvolution>()

            while (!evolveTo.isNullOrEmpty()) {
                evolveTo.forEach { evolveToCurrent ->
                    EvolutionDetail.lastTrigger = null
                    mappedList.add(
                        MappedEvolution(
                            toImageUrl = evolveToCurrent.species.url.extractId.imageUrl,
                            condition = when (evolveToCurrent.species.url.extractId) {
                                MelmetalId -> MelmetalCondition
                                else -> evolveToCurrent.evolutionDetails?.joinToString(NewLine) { it.validConditions }
                            },
                            fromImageUrl = currentSpecies?.url?.extractId?.imageUrl
                        )
                    )
                }
                currentSpecies = evolveTo.firstOrNull()?.species
                evolveTo = evolveTo.firstOrNull()?.evolvesTo
            }
            return mappedList.filter { !it.toImageUrl.isNullOrBlank() }
        }

    fun buildBabyItemMappedEvolution(list: List<MappedEvolution>) = babyTriggerItem?.let {
        val firstMappedEvolution = list.firstOrNull()
        val toImageUrl = firstMappedEvolution?.toImageUrl
        firstMappedEvolution?.copy(
            condition = "Breed holding ${babyTriggerItem.name.removeDash}",
            toImageUrl = firstMappedEvolution.fromImageUrl,
            fromImageUrl = toImageUrl
        )
    }

    private companion object {
        // Special cases
        const val MelmetalId = "809"
        const val MelmetalCondition = "Feed 400 Meltan Candy"
    }
}