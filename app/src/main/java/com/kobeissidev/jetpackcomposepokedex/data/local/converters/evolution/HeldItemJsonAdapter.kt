// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.evolution

import com.kobeissidev.jetpackcomposepokedex.data.model.evolution.HeldItem
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

public class HeldItemJsonAdapter(
  moshi: Moshi
) : JsonAdapter<HeldItem>() {
  private val options: JsonReader.Options = JsonReader.Options.of("name", "url")

  private val stringAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, emptySet(),
      "name")

  @Volatile
  private var constructorRef: Constructor<HeldItem>? = null

  public override fun toString(): String = buildString(30) {
      append("GeneratedJsonAdapter(").append("HeldItem").append(')') }

  public override fun fromJson(reader: JsonReader): HeldItem {
    var name: String? = null
    var url: String? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          name = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("name", "name", reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          url = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("url", "url", reader)
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
      return  HeldItem(
          name = name as String,
          url = url as String
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<HeldItem> = this.constructorRef ?:
          HeldItem::class.java.getDeclaredConstructor(String::class.java, String::class.java,
          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {
          this.constructorRef = it }
      return localConstructor.newInstance(
          name,
          url,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: HeldItem?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("name")
    stringAdapter.toJson(writer, value_.name)
    writer.name("url")
    stringAdapter.toJson(writer, value_.url)
    writer.endObject()
  }
}
