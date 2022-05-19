package com.kobeissidev.jetpackcomposepokedex.data.local.converters.supplementary;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class PaletteListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromPalette(List<Palette> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Palette.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<Palette> fromStringToPalette(String model) {
    if (model == null) return null;
    try {
    	return (List<Palette>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Palette.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
