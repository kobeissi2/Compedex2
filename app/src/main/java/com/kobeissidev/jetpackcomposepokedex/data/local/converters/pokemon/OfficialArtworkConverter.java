package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.OfficialArtwork;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

;

public class OfficialArtworkConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromOfficialArtwork(OfficialArtwork model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(OfficialArtwork.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static OfficialArtwork fromStringToOfficialArtwork(String model) {
    if (model == null) return null;
    try {
    	return (OfficialArtwork) new Moshi.Builder().build().adapter(OfficialArtwork.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
