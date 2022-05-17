package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionGroup;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class VersionGroupConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromVersionGroup(VersionGroup model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(VersionGroup.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static VersionGroup fromStringToVersionGroup(String model) {
    if (model == null) return null;
    try {
    	return (VersionGroup) new Moshi.Builder().build().adapter(VersionGroup.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
