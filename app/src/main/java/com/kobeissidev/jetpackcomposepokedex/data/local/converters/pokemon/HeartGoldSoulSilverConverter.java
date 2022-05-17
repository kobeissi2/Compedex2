package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.HeartGoldSoulSilver;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class HeartGoldSoulSilverConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromHeartGoldSoulSilver(HeartGoldSoulSilver model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(HeartGoldSoulSilver.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static HeartGoldSoulSilver fromStringToHeartGoldSoulSilver(String model) {
    if (model == null) return null;
    try {
    	return (HeartGoldSoulSilver) new Moshi.Builder().build().adapter(HeartGoldSoulSilver.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
