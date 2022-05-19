package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationIii;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class GenerationIiiConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationIii(GenerationIii model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationIii.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationIii fromStringToGenerationIii(String model) {
    if (model == null) return null;
    try {
    	return (GenerationIii) new Moshi.Builder().build().adapter(GenerationIii.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
