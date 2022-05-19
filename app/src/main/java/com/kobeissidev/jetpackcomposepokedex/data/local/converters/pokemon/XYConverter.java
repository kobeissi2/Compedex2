package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.XY;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class XYConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromXY(XY model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(XY.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static XY fromStringToXY(String model) {
    if (model == null) return null;
    try {
    	return (XY) new Moshi.Builder().build().adapter(XY.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
