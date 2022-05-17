// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.UltraSunUltraMoon
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.`internal`.Util
import java.lang.NullPointerException
import java.lang.reflect.Constructor
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.emptySet
import kotlin.jvm.Volatile
import kotlin.text.buildString

public class UltraSunUltraMoonJsonAdapter(
  moshi: Moshi
) : JsonAdapter<UltraSunUltraMoon>() {
  private val options: JsonReader.Options = JsonReader.Options.of("front_default", "front_female",
      "front_shiny", "front_shiny_female")

  private val nullableStringAdapter: JsonAdapter<String?> = moshi.adapter(String::class.java,
      emptySet(), "frontDefault")

  @Volatile
  private var constructorRef: Constructor<UltraSunUltraMoon>? = null

  public override fun toString(): String = buildString(39) {
      append("GeneratedJsonAdapter(").append("UltraSunUltraMoon").append(')') }

  public override fun fromJson(reader: JsonReader): UltraSunUltraMoon {
    var frontDefault: String? = null
    var frontFemale: String? = null
    var frontShiny: String? = null
    var frontShinyFemale: String? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          frontDefault = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          frontFemale = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        2 -> {
          frontShiny = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 2).inv()
          mask0 = mask0 and 0xfffffffb.toInt()
        }
        3 -> {
          frontShinyFemale = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 3).inv()
          mask0 = mask0 and 0xfffffff7.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfffffff0.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  UltraSunUltraMoon(
          frontDefault = frontDefault,
          frontFemale = frontFemale,
          frontShiny = frontShiny,
          frontShinyFemale = frontShinyFemale
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<UltraSunUltraMoon> = this.constructorRef ?:
          UltraSunUltraMoon::class.java.getDeclaredConstructor(String::class.java,
          String::class.java, String::class.java, String::class.java, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          frontDefault,
          frontFemale,
          frontShiny,
          frontShinyFemale,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: UltraSunUltraMoon?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("front_default")
    nullableStringAdapter.toJson(writer, value_.frontDefault)
    writer.name("front_female")
    nullableStringAdapter.toJson(writer, value_.frontFemale)
    writer.name("front_shiny")
    nullableStringAdapter.toJson(writer, value_.frontShiny)
    writer.name("front_shiny_female")
    nullableStringAdapter.toJson(writer, value_.frontShinyFemale)
    writer.endObject()
  }
}
