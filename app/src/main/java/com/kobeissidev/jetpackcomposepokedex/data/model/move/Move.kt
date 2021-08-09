package com.kobeissidev.jetpackcomposepokedex.data.model.move

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Move(
    @Json(name = "accuracy")
    val accuracy: Int = 0,
    @Json(name = "contest_combos")
    val contestCombos: ContestCombos = ContestCombos(),
    @Json(name = "contest_effect")
    val contestEffect: ContestEffect = ContestEffect(),
    @Json(name = "contest_type")
    val contestType: ContestType = ContestType(),
    @Json(name = "damage_class")
    val damageClass: DamageClass = DamageClass(),
    @Json(name = "effect_chance")
    val effectChance: String? = null,
    @Json(name = "effect_changes")
    val effectChanges: List<String> = listOf(),
    @Json(name = "effect_entries")
    val effectEntries: List<EffectEntry> = listOf(),
    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry> = listOf(),
    @Json(name = "generation")
    val generation: Generation = Generation(),
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "learned_by_pokemon")
    val learnedByPokemon: List<LearnedByPokemon> = listOf(),
    @Json(name = "machines")
    val machines: List<String> = listOf(),
    @Json(name = "meta")
    val meta: Meta = Meta(),
    @Json(name = "name")
    val name: String = "",
    @Json(name = "names")
    val names: List<Name> = listOf(),
    @Json(name = "past_values")
    val pastValues: List<String> = listOf(),
    @Json(name = "power")
    val power: Int = 0,
    @Json(name = "pp")
    val pp: Int = 0,
    @Json(name = "priority")
    val priority: Int = 0,
    @Json(name = "stat_changes")
    val statChanges: List<String> = listOf(),
    @Json(name = "super_contest_effect")
    val superContestEffect: SuperContestEffect = SuperContestEffect(),
    @Json(name = "target")
    val target: Target = Target(),
    @Json(name = "type")
    val type: Type = Type()
) : Parcelable