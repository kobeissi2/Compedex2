package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Versions;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class VersionsConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromVersions(Versions model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Versions.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Versions fromStringToVersions(String model) {
    if (model == null) return null;
    try {
    	return (Versions) new Moshi.Builder().build().adapter(Versions.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
