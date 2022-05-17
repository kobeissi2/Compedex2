package com.kobeissidev.jetpackcomposepokedex.data.local.converters.entry;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.entry.PokemonEntry;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class PokemonEntryConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromPokemonEntry(PokemonEntry model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(PokemonEntry.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static PokemonEntry fromStringToPokemonEntry(String model) {
    if (model == null) return null;
    try {
    	return (PokemonEntry) new Moshi.Builder().build().adapter(PokemonEntry.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
