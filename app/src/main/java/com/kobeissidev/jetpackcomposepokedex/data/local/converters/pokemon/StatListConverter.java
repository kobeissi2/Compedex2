package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Stat;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

;

public class StatListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromStat(List<Stat> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Stat.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<Stat> fromStringToStat(String model) {
    if (model == null) return null;
    try {
    	return (List<Stat>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Stat.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
