package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationV;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class GenerationVConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationV(GenerationV model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationV.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationV fromStringToGenerationV(String model) {
    if (model == null) return null;
    try {
    	return (GenerationV) new Moshi.Builder().build().adapter(GenerationV.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
