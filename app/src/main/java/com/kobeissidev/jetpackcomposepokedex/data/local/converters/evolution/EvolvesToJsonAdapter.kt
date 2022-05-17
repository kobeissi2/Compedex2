// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.evolution

import com.kobeissidev.jetpackcomposepokedex.data.model.evolution.EvolutionDetail
import com.kobeissidev.jetpackcomposepokedex.data.model.evolution.EvolvesTo
import com.kobeissidev.jetpackcomposepokedex.data.model.evolution.Species
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.`internal`.Util
import java.lang.NullPointerException
import java.lang.reflect.Constructor
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.emptySet
import kotlin.jvm.Volatile
import kotlin.text.buildString

public class EvolvesToJsonAdapter(
  moshi: Moshi
) : JsonAdapter<EvolvesTo>() {
  private val options: JsonReader.Options = JsonReader.Options.of("evolution_details", "evolves_to",
      "is_baby", "species")

  private val nullableListOfEvolutionDetailAdapter: JsonAdapter<List<EvolutionDetail>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, EvolutionDetail::class.java),
      emptySet(), "evolutionDetailList")

  private val nullableListOfEvolvesToAdapter: JsonAdapter<List<EvolvesTo>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, EvolvesTo::class.java), emptySet(),
      "evolvesTo")

  private val booleanAdapter: JsonAdapter<Boolean> = moshi.adapter(Boolean::class.java, emptySet(),
      "isBaby")

  private val speciesAdapter: JsonAdapter<Species> = moshi.adapter(Species::class.java, emptySet(),
      "species")

  @Volatile
  private var constructorRef: Constructor<EvolvesTo>? = null

  public override fun toString(): String = buildString(31) {
      append("GeneratedJsonAdapter(").append("EvolvesTo").append(')') }

  public override fun fromJson(reader: JsonReader): EvolvesTo {
    var evolutionDetailList: List<EvolutionDetail>? = null
    var evolvesTo: List<EvolvesTo>? = null
    var isBaby: Boolean? = false
    var species: Species? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          evolutionDetailList = nullableListOfEvolutionDetailAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          evolvesTo = nullableListOfEvolvesToAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        2 -> {
          isBaby = booleanAdapter.fromJson(reader) ?: throw Util.unexpectedNull("isBaby", "is_baby",
              reader)
          // $mask = $mask and (1 shl 2).inv()
          mask0 = mask0 and 0xfffffffb.toInt()
        }
        3 -> {
          species = speciesAdapter.fromJson(reader) ?: throw Util.unexpectedNull("species",
              "species", reader)
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
      return  EvolvesTo(
          evolutionDetailList = evolutionDetailList,
          evolvesTo = evolvesTo,
          isBaby = isBaby as Boolean,
          species = species as Species
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<EvolvesTo> = this.constructorRef ?:
          EvolvesTo::class.java.getDeclaredConstructor(List::class.java, List::class.java,
          Boolean::class.javaPrimitiveType, Species::class.java, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          evolutionDetailList,
          evolvesTo,
          isBaby,
          species,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: EvolvesTo?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("evolution_details")
    nullableListOfEvolutionDetailAdapter.toJson(writer, value_.evolutionDetailList)
    writer.name("evolves_to")
    nullableListOfEvolvesToAdapter.toJson(writer, value_.evolvesTo)
    writer.name("is_baby")
    booleanAdapter.toJson(writer, value_.isBaby)
    writer.name("species")
    speciesAdapter.toJson(writer, value_.species)
    writer.endObject()
  }
}