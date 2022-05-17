package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Silver;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class SilverConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromSilver(Silver model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Silver.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Silver fromStringToSilver(String model) {
    if (model == null) return null;
    try {
    	return (Silver) new Moshi.Builder().build().adapter(Silver.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
