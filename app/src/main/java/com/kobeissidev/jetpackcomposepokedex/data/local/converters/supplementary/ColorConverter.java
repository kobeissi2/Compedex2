package com.kobeissidev.jetpackcomposepokedex.data.local.converters.supplementary;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Color;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class ColorConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromColor(Color model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Color.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Color fromStringToColor(String model) {
    if (model == null) return null;
    try {
    	return (Color) new Moshi.Builder().build().adapter(Color.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
