package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationVii;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class GenerationViiConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationVii(GenerationVii model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationVii.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationVii fromStringToGenerationVii(String model) {
    if (model == null) return null;
    try {
    	return (GenerationVii) new Moshi.Builder().build().adapter(GenerationVii.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
