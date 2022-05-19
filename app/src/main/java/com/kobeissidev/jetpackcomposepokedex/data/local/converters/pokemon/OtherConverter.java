package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Other;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class OtherConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromOther(Other model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Other.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Other fromStringToOther(String model) {
    if (model == null) return null;
    try {
    	return (Other) new Moshi.Builder().build().adapter(Other.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
