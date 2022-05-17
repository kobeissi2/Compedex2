package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Item;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class ItemConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromItem(Item model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Item.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static Item fromStringToItem(String model) {
    if (model == null) return null;
    try {
    	return (Item) new Moshi.Builder().build().adapter(Item.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
