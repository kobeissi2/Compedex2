package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationViii;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class GenerationViiiConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationViii(GenerationViii model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationViii.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationViii fromStringToGenerationViii(String model) {
    if (model == null) return null;
    try {
    	return (GenerationViii) new Moshi.Builder().build().adapter(GenerationViii.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
