package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionGroupDetail;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

;

public class VersionGroupDetailListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromVersionGroupDetail(List<VersionGroupDetail> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,VersionGroupDetail.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<VersionGroupDetail> fromStringToVersionGroupDetail(String model) {
    if (model == null) return null;
    try {
    	return (List<VersionGroupDetail>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,VersionGroupDetail.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
