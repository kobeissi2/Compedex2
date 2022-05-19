package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Gold;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class GoldConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGold(Gold model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Gold.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Gold fromStringToGold(String model) {
    if (model == null) return null;
    try {
    	return (Gold) new Moshi.Builder().build().adapter(Gold.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
