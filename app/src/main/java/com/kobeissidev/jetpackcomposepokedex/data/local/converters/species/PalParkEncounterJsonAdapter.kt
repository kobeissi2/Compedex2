// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.species

import com.kobeissidev.jetpackcomposepokedex.data.model.species.Area
import com.kobeissidev.jetpackcomposepokedex.data.model.species.PalParkEncounter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.internal.Util
import java.lang.reflect.Constructor
import kotlin.Int

public class PalParkEncounterJsonAdapter(
  moshi: Moshi
) : JsonAdapter<PalParkEncounter>() {
  private val options: JsonReader.Options = JsonReader.Options.of("area", "base_score", "rate")

  private val areaAdapter: JsonAdapter<Area> = moshi.adapter(Area::class.java, emptySet(), "area")

  private val intAdapter: JsonAdapter<Int> = moshi.adapter(Int::class.java, emptySet(), "baseScore")

  @Volatile
  private var constructorRef: Constructor<PalParkEncounter>? = null

  public override fun toString(): String = buildString(38) {
      append("GeneratedJsonAdapter(").append("PalParkEncounter").append(')') }

  public override fun fromJson(reader: JsonReader): PalParkEncounter {
    var area: Area? = null
    var baseScore: Int? = 0
    var rate: Int? = 0
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          area = areaAdapter.fromJson(reader) ?: throw Util.unexpectedNull("area", "area", reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          baseScore = intAdapter.fromJson(reader) ?: throw Util.unexpectedNull("baseScore",
              "base_score", reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        2 -> {
          rate = intAdapter.fromJson(reader) ?: throw Util.unexpectedNull("rate", "rate", reader)
          // $mask = $mask and (1 shl 2).inv()
          mask0 = mask0 and 0xfffffffb.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfffffff8.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  PalParkEncounter(
          area = area as Area,
          baseScore = baseScore as Int,
          rate = rate as Int
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<PalParkEncounter> = this.constructorRef ?:
          PalParkEncounter::class.java.getDeclaredConstructor(Area::class.java,
          Int::class.javaPrimitiveType, Int::class.javaPrimitiveType, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          area,
          baseScore,
          rate,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: PalParkEncounter?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("area")
    areaAdapter.toJson(writer, value_.area)
    writer.name("base_score")
    intAdapter.toJson(writer, value_.baseScore)
    writer.name("rate")
    intAdapter.toJson(writer, value_.rate)
    writer.endObject()
  }
}
