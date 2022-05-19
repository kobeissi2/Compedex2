package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Move;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

;

public class MoveListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromMove(List<Move> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Move.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<Move> fromStringToMove(String model) {
    if (model == null) return null;
    try {
    	return (List<Move>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Move.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
