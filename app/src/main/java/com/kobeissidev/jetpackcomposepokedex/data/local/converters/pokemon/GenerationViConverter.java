package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationVi;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class GenerationViConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGenerationVi(GenerationVi model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(GenerationVi.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static GenerationVi fromStringToGenerationVi(String model) {
    if (model == null) return null;
    try {
    	return (GenerationVi) new Moshi.Builder().build().adapter(GenerationVi.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
