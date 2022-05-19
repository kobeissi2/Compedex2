package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Animated;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class AnimatedConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromAnimated(Animated model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Animated.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Animated fromStringToAnimated(String model) {
    if (model == null) return null;
    try {
    	return (Animated) new Moshi.Builder().build().adapter(Animated.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
