package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationIv;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class GenerationIvConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationIv(GenerationIv model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationIv.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationIv fromStringToGenerationIv(String model) {
    if (model == null) return null;
    try {
    	return (GenerationIv) new Moshi.Builder().build().adapter(GenerationIv.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
