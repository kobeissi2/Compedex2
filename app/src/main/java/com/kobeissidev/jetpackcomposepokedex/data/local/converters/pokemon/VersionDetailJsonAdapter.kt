// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionDetail
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.VersionX
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

public class VersionDetailJsonAdapter(
  moshi: Moshi
) : JsonAdapter<VersionDetail>() {
  private val options: JsonReader.Options = JsonReader.Options.of("rarity", "version")

  private val nullableIntAdapter: JsonAdapter<Int?> = moshi.adapter(Int::class.javaObjectType,
      emptySet(), "rarity")

  private val nullableVersionXAdapter: JsonAdapter<VersionX?> = moshi.adapter(VersionX::class.java,
      emptySet(), "version")

  @Volatile
  private var constructorRef: Constructor<VersionDetail>? = null

  public override fun toString(): String = buildString(35) {
      append("GeneratedJsonAdapter(").append("VersionDetail").append(')') }

  public override fun fromJson(reader: JsonReader): VersionDetail {
    var rarity: Int? = null
    var version: VersionX? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          rarity = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          version = nullableVersionXAdapter.fromJson(reader)
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
      return  VersionDetail(
          rarity = rarity,
          version = version
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<VersionDetail> = this.constructorRef ?:
          VersionDetail::class.java.getDeclaredConstructor(Int::class.javaObjectType,
          VersionX::class.java, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          rarity,
          version,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: VersionDetail?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("rarity")
    nullableIntAdapter.toJson(writer, value_.rarity)
    writer.name("version")
    nullableVersionXAdapter.toJson(writer, value_.version)
    writer.endObject()
  }
}