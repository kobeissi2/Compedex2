package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.TypeX;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class TypeXConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromTypeX(TypeX model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(TypeX.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static TypeX fromStringToTypeX(String model) {
    if (model == null) return null;
    try {
    	return (TypeX) new Moshi.Builder().build().adapter(TypeX.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
