package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.AbilityX;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class AbilityXConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromAbilityX(AbilityX model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(AbilityX.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static AbilityX fromStringToAbilityX(String model) {
    if (model == null) return null;
    try {
    	return (AbilityX) new Moshi.Builder().build().adapter(AbilityX.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
