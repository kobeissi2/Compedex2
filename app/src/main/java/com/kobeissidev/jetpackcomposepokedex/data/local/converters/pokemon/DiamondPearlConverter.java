package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.DiamondPearl;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class DiamondPearlConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromDiamondPearl(DiamondPearl model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(DiamondPearl.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static DiamondPearl fromStringToDiamondPearl(String model) {
    if (model == null) return null;
    try {
    	return (DiamondPearl) new Moshi.Builder().build().adapter(DiamondPearl.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
