package com.kobeissidev.jetpackcomposepokedex.data.model.evolution

import android.os.Parcelable
import com.kobeissidev.jetpackcomposepokedex.data.model.move.Move
import com.kobeissidev.jetpackcomposepokedex.data.model.move.Type
import com.kobeissidev.jetpackcomposepokedex.util.NewLine
import com.kobeissidev.jetpackcomposepokedex.util.NotFound
import com.kobeissidev.jetpackcomposepokedex.util.removeDash
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class EvolutionDetail(
    @Json(name = "gender")
    val gender: Int? = null,
    @Json(name = "held_item")
    val heldItem: HeldItem? = null,
    @Json(name = "item")
    val item: Item? = null,
    @Json(name = "known_move")
    val knownMove: Move? = null,
    @Json(name = "known_move_type")
    val knownMoveType: Type? = null,
    @Json(name = "location")
    val location: Location? = null,
    @Json(name = "min_affection")
    val minAffection: Int? = null,
    @Json(name = "min_beauty")
    val minBeauty: Int? = null,
    @Json(name = "min_happiness")
    val minHappiness: Int? = null,
    @Json(name = "min_level")
    val minLevel: Int? = null,
    @Json(name = "needs_overworld_rain")
    val needsOverworldRain: Boolean? = false,
    @Json(name = "party_species")
    val partySpecies: Species? = null,
    @Json(name = "party_type")
    val partyType: Type? = null,
    @Json(name = "relative_physical_stats")
    val relativePhysicalStats: Int? = null,
    @Json(name = "time_of_day")
    val timeOfDay: String? = null,
    @Json(name = "trade_species")
    val tradeSpecies: Species? = null,
    @Json(name = "trigger")
    val trigger: Trigger? = Trigger(),
    @Json(name = "turn_upside_down")
    val turnUpsideDown: Boolean? = false
) : Parcelable {

    /**
     * Check each and every field to see if it is a valid condition.
     * Not a fan of this method but API doesn't provide a method to check without checking every one.
     */
    val validConditions: String
        get() = StringBuilder().apply {
            val trigger = trigger?.name
            if (!trigger.isNullOrBlank() && lastTrigger != trigger) {
                lastTrigger = trigger
                append(trigger.removeDash).append(NewLine)
            }
            if ((minLevel ?: NotFound) > NotFound) {
                append("At Level $minLevel").append(NewLine)
            }
            if (!heldItem?.name.isNullOrBlank()) {
                append("With ${heldItem!!.name.removeDash} Held").append(NewLine)
            }
            if ((gender ?: NotFound) == Male) {
                append("Male Only").append(NewLine)
            }
            if ((gender ?: NotFound) == Female) {
                append("Female Only").append(NewLine)
            }
            if (!item?.name.isNullOrBlank()) {
                append(item!!.name.removeDash).append(NewLine)
            }
            if (!knownMove?.name.isNullOrBlank()) {
                append("With ${knownMove!!.name.removeDash} Learned").append(NewLine)
            }
            if ((!knownMoveType?.name.isNullOrBlank())) {
                append("With ${knownMoveType!!.name.removeDash} Type Learned").append(NewLine)
            }
            if ((!location?.name.isNullOrBlank())) {
                append("At ${location!!.name.removeDash}").append(NewLine)
            }
            if ((minAffection ?: NotFound) > NotFound) {
                append("With ${minAffection}+ Affection").append(NewLine)
            }
            if ((minBeauty ?: NotFound) > NotFound) {
                append("With ${minBeauty}+ Beauty").append(NewLine)
            }
            if ((minHappiness ?: NotFound) > NotFound) {
                append("With ${minHappiness}+ Happiness").append(NewLine)
            }
            if (needsOverworldRain == true) {
                append("With Rain").append(NewLine)
            }
            if (!partySpecies?.name.isNullOrBlank()) {
                append("Have a ${partySpecies!!.name.removeDash} Species In Party").append(NewLine)
            }
            if (!partyType?.name.isNullOrBlank()) {
                append("Have a ${partyType!!.name.removeDash} Type In Party").append(NewLine)
            }
            when (relativePhysicalStats) {
                MoreAttack -> append("With Attack > Defense").append(NewLine)
                MoreDefense -> append("With Attack < Defense").append(NewLine)
                SameAttack -> append("With Attack = Defense").append(NewLine)
            }
            if (!timeOfDay.isNullOrBlank()) {
                append("At ${timeOfDay.removeDash} Time Only").append(NewLine)
            }
            if (!tradeSpecies?.name.isNullOrBlank()) {
                append("And Trade ${tradeSpecies!!.name.removeDash}").append(NewLine)
            }
            if (turnUpsideDown == true) {
                append("And Turn Console Upside Down").append(NewLine)
            }
        }.trim().toString()

    companion object {
        var lastTrigger: String? = null
        private const val Male = 2
        private const val Female = 1
        private const val MoreAttack = 1
        private const val MoreDefense = -1
        private const val SameAttack = 0
    }
}