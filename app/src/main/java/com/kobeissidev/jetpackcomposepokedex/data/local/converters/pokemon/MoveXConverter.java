package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.MoveX;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class MoveXConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromMoveX(MoveX model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(MoveX.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static MoveX fromStringToMoveX(String model) {
    if (model == null) return null;
    try {
    	return (MoveX) new Moshi.Builder().build().adapter(MoveX.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
