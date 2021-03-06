// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationVii
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Icons
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.UltraSunUltraMoon
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.internal.Util
import java.lang.reflect.Constructor
import kotlin.Int

public class GenerationViiJsonAdapter(
  moshi: Moshi
) : JsonAdapter<GenerationVii>() {
  private val options: JsonReader.Options = JsonReader.Options.of("icons", "ultra-sun-ultra-moon")

  private val nullableIconsAdapter: JsonAdapter<Icons?> = moshi.adapter(Icons::class.java,
      emptySet(), "icons")

  private val nullableUltraSunUltraMoonAdapter: JsonAdapter<UltraSunUltraMoon?> =
      moshi.adapter(UltraSunUltraMoon::class.java, emptySet(), "ultraSunUltraMoon")

  @Volatile
  private var constructorRef: Constructor<GenerationVii>? = null

  public override fun toString(): String = buildString(35) {
      append("GeneratedJsonAdapter(").append("GenerationVii").append(')') }

  public override fun fromJson(reader: JsonReader): GenerationVii {
    var icons: Icons? = null
    var ultraSunUltraMoon: UltraSunUltraMoon? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          icons = nullableIconsAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          ultraSunUltraMoon = nullableUltraSunUltraMoonAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfffffffc.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  GenerationVii(
          icons = icons,
          ultraSunUltraMoon = ultraSunUltraMoon
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<GenerationVii> = this.constructorRef ?:
          GenerationVii::class.java.getDeclaredConstructor(Icons::class.java,
          UltraSunUltraMoon::class.java, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          icons,
          ultraSunUltraMoon,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: GenerationVii?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("icons")
    nullableIconsAdapter.toJson(writer, value_.icons)
    writer.name("ultra-sun-ultra-moon")
    nullableUltraSunUltraMoonAdapter.toJson(writer, value_.ultraSunUltraMoon)
    writer.endObject()
  }
}
