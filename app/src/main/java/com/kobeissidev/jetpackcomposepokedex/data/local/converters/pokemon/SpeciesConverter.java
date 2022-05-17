package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Species;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class SpeciesConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromSpecies(Species model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Species.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Species fromStringToSpecies(String model) {
    if (model == null) return null;
    try {
    	return (Species) new Moshi.Builder().build().adapter(Species.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
