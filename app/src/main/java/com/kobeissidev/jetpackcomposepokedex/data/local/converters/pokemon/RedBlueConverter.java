package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.RedBlue;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class RedBlueConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromRedBlue(RedBlue model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(RedBlue.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static RedBlue fromStringToRedBlue(String model) {
    if (model == null) return null;
    try {
    	return (RedBlue) new Moshi.Builder().build().adapter(RedBlue.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
