package com.kobeissidev.jetpackcomposepokedex.data.local.converters.remotekey;

import androidx.room.TypeConverter;

import com.kobeissidev.jetpackcomposepokedex.data.model.remotekey.RemoteKey;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.String;
import org.jetbrains.annotations.Nullable;

public class RemoteKeyConverter {
  @TypeConverter
  @Nullable
  public static String toStringFromRemoteKey(RemoteKey model) {
    if (model == null) return null;
    return new Moshi.Builder().build().adapter(RemoteKey.class).toJson(model);
  }

  @TypeConverter
  @Nullable
  public static RemoteKey fromStringToRemoteKey(String model) {
    if (model == null) return null;
    try {
    	return (RemoteKey) new Moshi.Builder().build().adapter(RemoteKey.class).fromJson(model);
    } catch (IOException e) {
    	e.printStackTrace();
    	return null;
    }
  }
}
