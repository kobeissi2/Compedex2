package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.IconsX;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class IconsXConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromIconsX(IconsX model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(IconsX.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static IconsX fromStringToIconsX(String model) {
    if (model == null) return null;
    try {
    	return (IconsX) new Moshi.Builder().build().adapter(IconsX.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
