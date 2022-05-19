package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.MoveLearnMethod;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class MoveLearnMethodConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromMoveLearnMethod(MoveLearnMethod model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(MoveLearnMethod.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static MoveLearnMethod fromStringToMoveLearnMethod(String model) {
    if (model == null) return null;
    try {
    	return (MoveLearnMethod) new Moshi.Builder().build().adapter(MoveLearnMethod.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
