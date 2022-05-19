package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationIi;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class GenerationIiConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationIi(GenerationIi model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationIi.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationIi fromStringToGenerationIi(String model) {
    if (model == null) return null;
    try {
    	return (GenerationIi) new Moshi.Builder().build().adapter(GenerationIi.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
