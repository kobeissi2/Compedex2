package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Sprites;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class SpritesConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromSprites(Sprites model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Sprites.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Sprites fromStringToSprites(String model) {
    if (model == null) return null;
    try {
    	return (Sprites) new Moshi.Builder().build().adapter(Sprites.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
