package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class PokemonConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromPokemon(Pokemon model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Pokemon.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Pokemon fromStringToPokemon(String model) {
    if (model == null) return null;
    try {
    	return (Pokemon) new Moshi.Builder().build().adapter(Pokemon.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
