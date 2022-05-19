package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.RubySapphire;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class RubySapphireConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromRubySapphire(RubySapphire model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(RubySapphire.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static RubySapphire fromStringToRubySapphire(String model) {
    if (model == null) return null;
    try {
    	return (RubySapphire) new Moshi.Builder().build().adapter(RubySapphire.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
