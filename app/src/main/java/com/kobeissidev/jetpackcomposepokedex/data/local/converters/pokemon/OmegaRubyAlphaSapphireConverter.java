package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.OmegaRubyAlphaSapphire;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class OmegaRubyAlphaSapphireConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromOmegaRubyAlphaSapphire(OmegaRubyAlphaSapphire model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(OmegaRubyAlphaSapphire.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static OmegaRubyAlphaSapphire fromStringToOmegaRubyAlphaSapphire(String model) {
    if (model == null) return null;
    try {
    	return (OmegaRubyAlphaSapphire) new Moshi.Builder().build().adapter(OmegaRubyAlphaSapphire.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
