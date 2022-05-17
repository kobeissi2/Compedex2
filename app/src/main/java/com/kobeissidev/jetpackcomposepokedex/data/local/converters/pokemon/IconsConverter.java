package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Icons;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class IconsConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromIcons(Icons model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Icons.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Icons fromStringToIcons(String model) {
    if (model == null) return null;
    try {
    	return (Icons) new Moshi.Builder().build().adapter(Icons.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
