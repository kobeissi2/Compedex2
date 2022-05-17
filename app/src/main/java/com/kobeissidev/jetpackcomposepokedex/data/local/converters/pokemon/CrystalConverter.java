package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Crystal;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class CrystalConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromCrystal(Crystal model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Crystal.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Crystal fromStringToCrystal(String model) {
    if (model == null) return null;
    try {
    	return (Crystal) new Moshi.Builder().build().adapter(Crystal.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
