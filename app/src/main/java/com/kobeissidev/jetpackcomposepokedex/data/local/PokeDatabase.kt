package com.kobeissidev.jetpackcomposepokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kobeissidev.jetpackcomposepokedex.data.model.entry.PokemonEntry
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.remotekey.RemoteKey

/**
 * Database containing the Pokemon entries, Pokemon data and remote keys.
 * Type Converters are generated automatically with the AutoBindings library and manually added here.
 */
@Database(entities = [Pokemon::class, PokemonEntry::class, RemoteKey::class], version = 1)
@TypeConverters(
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.AbilityListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.AbilityXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.AnimatedConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.BlackWhiteConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.CrystalConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.DiamondPearlConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.DreamWorldConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.EmeraldConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.FireRedLeafGreenConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.FormListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GameIndiceListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationIConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationIiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationIiiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationIvConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationVConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationViConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationViiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationViiiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GoldConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.HeartGoldSoulSilverConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.HeldItemListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.IconsConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.IconsXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.ItemConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.MoveListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.MoveLearnMethodConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.MoveXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.OfficialArtworkConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.OmegaRubyAlphaSapphireConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.OtherConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.PlatinumConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.PokemonConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.RedBlueConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.RubySapphireConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.SilverConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.SpeciesConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.SpritesConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.StatListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.StatXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.TypeListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.TypeXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.UltraSunUltraMoonConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionDetailListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionGroupConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionGroupDetailListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionsConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.XYConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.YellowConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.entry.ResultListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.PaletteListConverter::class
)
abstract class PokeDatabase : RoomDatabase() {
    abstract fun pokedexDao(): PokeDao
}