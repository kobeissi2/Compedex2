// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.move

import com.kobeissidev.jetpackcomposepokedex.data.model.move.ContestEffect
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

public class ContestEffectJsonAdapter(
  moshi: Moshi
) : JsonAdapter<ContestEffect>() {
  private val options: JsonReader.Options = JsonReader.Options.of("url")

  private val stringAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, emptySet(),
      "url")

  @Volatile
  private var constructorRef: Constructor<ContestEffect>? = null

  public override fun toString(): String = buildString(35) {
      append("GeneratedJsonAdapter(").append("ContestEffect").append(')') }

  public override fun fromJson(reader: JsonReader): ContestEffect {
    var url: String? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          url = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("url", "url", reader)
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
      return  ContestEffect(
          url = url as String
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<ContestEffect> = this.constructorRef ?:
          ContestEffect::class.java.getDeclaredConstructor(String::class.java,
          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {
          this.constructorRef = it }
      return localConstructor.newInstance(
          url,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: ContestEffect?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("url")
    stringAdapter.toJson(writer, value_.url)
    writer.endObject()
  }
}