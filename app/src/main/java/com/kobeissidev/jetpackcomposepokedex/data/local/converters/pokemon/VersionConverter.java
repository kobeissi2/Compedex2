package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Version;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class VersionConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromVersion(Version model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Version.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Version fromStringToVersion(String model) {
    if (model == null) return null;
    try {
    	return (Version) new Moshi.Builder().build().adapter(Version.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
