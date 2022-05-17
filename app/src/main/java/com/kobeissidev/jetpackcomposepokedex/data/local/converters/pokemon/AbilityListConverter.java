package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Ability;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.String;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class AbilityListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromAbility(List<Ability> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Ability.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<Ability> fromStringToAbility(String model) {
    if (model == null) return null;
    try {
    	return (List<Ability>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Ability.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
