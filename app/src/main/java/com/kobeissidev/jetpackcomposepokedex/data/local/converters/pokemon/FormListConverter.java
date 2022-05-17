package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon;;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Form;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.String;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class FormListConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromForm(List<Form> model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Form.class)).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static List<Form> fromStringToForm(String model) {
    if (model == null) return null;
    try {
    	return (List<Form>) new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class,Form.class)).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
