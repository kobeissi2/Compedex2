package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Platinum;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class PlatinumConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromPlatinum(Platinum model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Platinum.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Platinum fromStringToPlatinum(String model) {
    if (model == null) return null;
    try {
    	return (Platinum) new Moshi.Builder().build().adapter(Platinum.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
