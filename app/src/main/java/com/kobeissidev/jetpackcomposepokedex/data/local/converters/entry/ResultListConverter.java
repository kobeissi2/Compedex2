package com.kobeissidev.jetpackcomposepokedex.data.local.converters.entry;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.entry.Result;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class ResultListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromResult(List<Result> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Result.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<Result> fromStringToResult(String model) {
    if (model == null) return null;
    try {
    	return (List<Result>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Result.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
