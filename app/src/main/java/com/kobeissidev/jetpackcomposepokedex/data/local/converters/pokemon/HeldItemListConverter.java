package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.HeldItem;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.String;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class HeldItemListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromHeldItem(List<HeldItem> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,HeldItem.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<HeldItem> fromStringToHeldItem(String model) {
    if (model == null) return null;
    try {
    	return (List<HeldItem>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,HeldItem.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
