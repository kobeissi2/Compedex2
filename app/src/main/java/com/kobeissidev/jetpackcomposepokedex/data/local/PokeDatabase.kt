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
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.AbilityListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.AbilityXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.AnimatedConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.BlackWhiteConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.CrystalConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.DiamondPearlConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.DreamWorldConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.EmeraldConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.FireRedLeafGreenConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.FormListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GameIndiceListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationIConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationIiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationIiiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationIvConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationVConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationViConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationViiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GenerationViiiConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.GoldConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.HeartGoldSoulSilverConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.HeldItemListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.IconsConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.IconsXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.ItemConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.MoveListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.MoveLearnMethodConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.MoveXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.OfficialArtworkConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.OmegaRubyAlphaSapphireConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.OtherConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.PlatinumConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.PokemonConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.RedBlueConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.RubySapphireConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.SilverConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.SpeciesConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.SpritesConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.StatListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.StatXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.TypeListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.TypeXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.UltraSunUltraMoonConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.VersionConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.VersionDetailListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.VersionGroupConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.VersionGroupDetailListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.VersionsConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.VersionXConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.XYConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon.YellowConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.entry.ResultListConverter::class,
    com.kobeissidev.jetpackcomposepokedex.data.local.converters.supplementary.PaletteListConverter::class
)
abstract class PokeDatabase : RoomDatabase() {
    abstract fun pokedexDao(): PokeDao
}