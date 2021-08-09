package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.kobeissidev.jetpackcomposepokedex.ui.composable.autocomplete.AutoCompleteEntity
import com.kobeissidev.jetpackcomposepokedex.util.Dash
import com.kobeissidev.jetpackcomposepokedex.util.imageUrl
import com.kobeissidev.jetpackcomposepokedex.util.removeDash
import com.kobeissidev.jetpackcomposepokedex.util.spriteUrl
import com.kpstv.bindings.AutoGenerateConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity(tableName = "pokemon")
@AutoGenerateConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class Pokemon(
    val abilities: List<Ability>? = null,
    @Json(name = "base_experience") val baseExperience: Int? = null,
    val forms: List<Form>? = null,
    @Json(name = "game_indices") val gameIndices: List<GameIndice>? = null,
    val height: Int? = null,
    @Json(name = "held_items") val heldItems: List<HeldItem>? = null,
    @PrimaryKey val id: Int,
    @Json(name = "is_default") val isDefault: Boolean? = null,
    @Json(name = "location_area_encounters") val locationAreaEncounters: String? = null,
    val moves: List<Move>? = null,
    @Json(name = "name") val originalName: String,
    val order: Int? = null,
    @Json(name = "past_types") val pastTypes: List<Type>? = null,
    val species: Species? = null,
    val sprites: Sprites? = null,
    val stats: List<Stat>? = null,
    val types: List<Type>? = null,
    val weight: Int? = null,
    var paletteList: List<Palette> = listOf()
) : Parcelable, AutoCompleteEntity {

    /**
     * Gets the image url using the id.
     */
    val imageUrl get() = id.imageUrl

    /**
     * Gets the sprite url using the id.
     */
    val spriteUrl get() = id.spriteUrl

    /**
     * Gets the pokemon number formatted in the #XXX format
     */
    val number get() = "${NumberSign}${"$id".padStart(PokemonNumberSize, PadChar)}"

    /**
     * Main Palette to use for the UI
     */
    val primaryPalette get() = paletteList.find { it.isDefault } ?: Palette(name = name)

    /**
     * Remove forms from names.
     */
    val name
        get() = when {
            !specialCases.contains(originalName) -> originalName.removeDash
            else -> originalName.split(Dash).first().capitalize(Locale.current)
        }

    /**
     * Shuffles the Palette found on the image and returns the first one.
     */
    val shuffledPalette
        get() = paletteList.filterNot { it.isDefault }.take(TotalSwatches).shuffled().first()

    /**
     * Used for Autocomplete
     */
    override fun filter(query: String) = name.toLowerCase(Locale.current)
        .startsWith(query.toLowerCase(Locale.current)) || id.toString().startsWith(query)

    private companion object {
        // Currently all Pokemon numbers are three digits maximum
        const val PokemonNumberSize = 3
        const val PadChar = '0'
        const val NumberSign = '#'
        const val TotalSwatches = 3
        // Special Cases
        // Not a fan of this approach.
        val specialCases = listOf(
            "deoxys-normal",
            "lycanroc-midday",
            "giratina-altered",
            "basculin-red-striped",
            "wormadam-plant",
            "shaymin-land",
            "darmanitan-standard",
            "tornadus-incarnate",
            "thundurus-incarnate",
            "landorus-incarnate",
            "keldeo-ordinary",
            "meloetta-aria",
            "meowstic-male",
            "aegislash-shield",
            "pumpkaboo-average",
            "gourgeist-average",
            "oricorio-baile",
            "wishiwashi-solo",
            "minior-red-meteor",
            "mimikyu-disguised",
            "toxtricity-amped",
            "eiscue-ice",
            "indeedee-male",
            "zacian-hero",
            "zamazenta-hero",
            "urshifu-single-strike"
        )
    }
}