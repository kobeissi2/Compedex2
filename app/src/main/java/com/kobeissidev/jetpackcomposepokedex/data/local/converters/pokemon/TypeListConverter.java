package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Type;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.String;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class TypeListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromType(List<Type> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Type.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<Type> fromStringToType(String model) {
    if (model == null) return null;
    try {
    	return (List<Type>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Type.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
