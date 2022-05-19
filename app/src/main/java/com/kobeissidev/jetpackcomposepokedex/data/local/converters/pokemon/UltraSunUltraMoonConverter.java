package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.UltraSunUltraMoon;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class UltraSunUltraMoonConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromUltraSunUltraMoon(UltraSunUltraMoon model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(UltraSunUltraMoon.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static UltraSunUltraMoon fromStringToUltraSunUltraMoon(String model) {
    if (model == null) return null;
    try {
    	return (UltraSunUltraMoon) new Moshi.Builder().build().adapter(UltraSunUltraMoon.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
