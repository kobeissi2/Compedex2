package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.BlackWhite;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class BlackWhiteConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromBlackWhite(BlackWhite model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(BlackWhite.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static BlackWhite fromStringToBlackWhite(String model) {
    if (model == null) return null;
    try {
    	return (BlackWhite) new Moshi.Builder().build().adapter(BlackWhite.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
