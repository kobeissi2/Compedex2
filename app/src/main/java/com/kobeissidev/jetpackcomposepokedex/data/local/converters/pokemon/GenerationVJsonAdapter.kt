// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.BlackWhite
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.GenerationV
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

public class GenerationVJsonAdapter(
  moshi: Moshi
) : JsonAdapter<GenerationV>() {
  private val options: JsonReader.Options = JsonReader.Options.of("black-white")

  private val nullableBlackWhiteAdapter: JsonAdapter<BlackWhite?> =
      moshi.adapter(BlackWhite::class.java, emptySet(), "blackWhite")

  @Volatile
  private var constructorRef: Constructor<GenerationV>? = null

  public override fun toString(): String = buildString(33) {
      append("GeneratedJsonAdapter(").append("GenerationV").append(')') }

  public override fun fromJson(reader: JsonReader): GenerationV {
    var blackWhite: BlackWhite? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          blackWhite = nullableBlackWhiteAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfffffffe.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  GenerationV(
          blackWhite = blackWhite
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<GenerationV> = this.constructorRef ?:
          GenerationV::class.java.getDeclaredConstructor(BlackWhite::class.java,
          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {
          this.constructorRef = it }
      return localConstructor.newInstance(
          blackWhite,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: GenerationV?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("black-white")
    nullableBlackWhiteAdapter.toJson(writer, value_.blackWhite)
    writer.endObject()
  }
}