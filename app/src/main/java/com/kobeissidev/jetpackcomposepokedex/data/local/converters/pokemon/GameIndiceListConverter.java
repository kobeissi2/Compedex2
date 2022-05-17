package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GameIndice;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.String;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class GameIndiceListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromGameIndice(List<GameIndice> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,GameIndice.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<GameIndice> fromStringToGameIndice(String model) {
    if (model == null) return null;
    try {
    	return (List<GameIndice>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,GameIndice.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
