package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.StatX;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class StatXConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromStatX(StatX model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(StatX.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static StatX fromStringToStatX(String model) {
    if (model == null) return null;
    try {
    	return (StatX) new Moshi.Builder().build().adapter(StatX.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
