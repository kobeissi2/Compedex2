package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.DreamWorld;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class DreamWorldConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromDreamWorld(DreamWorld model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(DreamWorld.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static DreamWorld fromStringToDreamWorld(String model) {
    if (model == null) return null;
    try {
    	return (DreamWorld) new Moshi.Builder().build().adapter(DreamWorld.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
