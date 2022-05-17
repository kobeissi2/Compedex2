package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Emerald;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class EmeraldConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromEmerald(Emerald model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Emerald.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Emerald fromStringToEmerald(String model) {
    if (model == null) return null;
    try {
    	return (Emerald) new Moshi.Builder().build().adapter(Emerald.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
