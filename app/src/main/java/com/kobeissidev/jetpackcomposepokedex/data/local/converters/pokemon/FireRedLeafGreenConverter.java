package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.FireRedLeafGreen;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class FireRedLeafGreenConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromFireRedLeafGreen(FireRedLeafGreen model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(FireRedLeafGreen.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static FireRedLeafGreen fromStringToFireRedLeafGreen(String model) {
    if (model == null) return null;
    try {
    	return (FireRedLeafGreen) new Moshi.Builder().build().adapter(FireRedLeafGreen.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
