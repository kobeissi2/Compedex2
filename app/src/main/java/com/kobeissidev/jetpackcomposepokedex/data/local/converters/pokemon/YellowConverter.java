package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Yellow;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class YellowConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromYellow(Yellow model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Yellow.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Yellow fromStringToYellow(String model) {
    if (model == null) return null;
    try {
    	return (Yellow) new Moshi.Builder().build().adapter(Yellow.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
