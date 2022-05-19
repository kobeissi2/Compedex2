package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationI;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class GenerationIConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationI(GenerationI model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationI.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationI fromStringToGenerationI(String model) {
    if (model == null) return null;
    try {
    	return (GenerationI) new Moshi.Builder().build().adapter(GenerationI.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
