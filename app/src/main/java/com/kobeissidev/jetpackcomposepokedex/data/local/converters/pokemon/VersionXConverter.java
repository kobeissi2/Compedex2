package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionX;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class VersionXConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromVersionX(VersionX model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(VersionX.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static VersionX fromStringToVersionX(String model) {
    if (model == null) return null;
    try {
    	return (VersionX) new Moshi.Builder().build().adapter(VersionX.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
