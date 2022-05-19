package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionDetail;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

;

public class VersionDetailListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromVersionDetail(List<VersionDetail> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,VersionDetail.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<VersionDetail> fromStringToVersionDetail(String model) {
    if (model == null) return null;
    try {
    	return (List<VersionDetail>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,VersionDetail.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
