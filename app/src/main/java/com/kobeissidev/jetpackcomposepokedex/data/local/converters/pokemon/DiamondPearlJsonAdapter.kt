// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.DiamondPearl
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.internal.Util
import java.lang.reflect.Constructor
import kotlin.Int
import kotlin.String

public class DiamondPearlJsonAdapter(
  moshi: Moshi
) : JsonAdapter<DiamondPearl>() {
  private val options: JsonReader.Options = JsonReader.Options.of("back_default", "back_female",
      "back_shiny", "back_shiny_female", "front_default", "front_female", "front_shiny",
      "front_shiny_female")

  private val nullableStringAdapter: JsonAdapter<String?> = moshi.adapter(String::class.java,
      emptySet(), "backDefault")

  @Volatile
  private var constructorRef: Constructor<DiamondPearl>? = null

  public override fun toString(): String = buildString(34) {
      append("GeneratedJsonAdapter(").append("DiamondPearl").append(')') }

  public override fun fromJson(reader: JsonReader): DiamondPearl {
    var backDefault: String? = null
    var backFemale: String? = null
    var backShiny: String? = null
    var backShinyFemale: String? = null
    var frontDefault: String? = null
    var frontFemale: String? = null
    var frontShiny: String? = null
    var frontShinyFemale: String? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          backDefault = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          backFemale = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        2 -> {
          backShiny = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 2).inv()
          mask0 = mask0 and 0xfffffffb.toInt()
        }
        3 -> {
          backShinyFemale = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 3).inv()
          mask0 = mask0 and 0xfffffff7.toInt()
        }
        4 -> {
          frontDefault = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 4).inv()
          mask0 = mask0 and 0xffffffef.toInt()
        }
        5 -> {
          frontFemale = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 5).inv()
          mask0 = mask0 and 0xffffffdf.toInt()
        }
        6 -> {
          frontShiny = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 6).inv()
          mask0 = mask0 and 0xffffffbf.toInt()
        }
        7 -> {
          frontShinyFemale = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 7).inv()
          mask0 = mask0 and 0xffffff7f.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xffffff00.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  DiamondPearl(
          backDefault = backDefault,
          backFemale = backFemale,
          backShiny = backShiny,
          backShinyFemale = backShinyFemale,
          frontDefault = frontDefault,
          frontFemale = frontFemale,
          frontShiny = frontShiny,
          frontShinyFemale = frontShinyFemale
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<DiamondPearl> = this.constructorRef ?:
          DiamondPearl::class.java.getDeclaredConstructor(String::class.java, String::class.java,
          String::class.java, String::class.java, String::class.java, String::class.java,
          String::class.java, String::class.java, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          backDefault,
          backFemale,
          backShiny,
          backShinyFemale,
          frontDefault,
          frontFemale,
          frontShiny,
          frontShinyFemale,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: DiamondPearl?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("back_default")
    nullableStringAdapter.toJson(writer, value_.backDefault)
    writer.name("back_female")
    nullableStringAdapter.toJson(writer, value_.backFemale)
    writer.name("back_shiny")
    nullableStringAdapter.toJson(writer, value_.backShiny)
    writer.name("back_shiny_female")
    nullableStringAdapter.toJson(writer, value_.backShinyFemale)
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
