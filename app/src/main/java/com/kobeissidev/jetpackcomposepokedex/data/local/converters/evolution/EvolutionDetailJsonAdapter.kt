// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.evolution

import com.kobeissidev.jetpackcomposepokedex.data.model.evolution.*
import com.kobeissidev.jetpackcomposepokedex.data.model.move.Move
import com.kobeissidev.jetpackcomposepokedex.data.model.move.Type
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.`internal`.Util
import java.lang.NullPointerException
import java.lang.reflect.Constructor
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.emptySet
import kotlin.jvm.Volatile
import kotlin.text.buildString

public class EvolutionDetailJsonAdapter(
  moshi: Moshi
) : JsonAdapter<EvolutionDetail>() {
  private val options: JsonReader.Options = JsonReader.Options.of("gender", "held_item", "item",
      "known_move", "known_move_type", "location", "min_affection", "min_beauty", "min_happiness",
      "min_level", "needs_overworld_rain", "party_species", "party_type", "relative_physical_stats",
      "time_of_day", "trade_species", "trigger", "turn_upside_down")

  private val nullableIntAdapter: JsonAdapter<Int?> = moshi.adapter(Int::class.javaObjectType,
      emptySet(), "gender")

  private val nullableHeldItemAdapter: JsonAdapter<HeldItem?> = moshi.adapter(HeldItem::class.java,
      emptySet(), "heldItem")

  private val nullableItemAdapter: JsonAdapter<Item?> = moshi.adapter(Item::class.java, emptySet(),
      "item")

  private val nullableMoveAdapter: JsonAdapter<Move?> = moshi.adapter(Move::class.java, emptySet(),
      "knownMove")

  private val nullableTypeAdapter: JsonAdapter<Type?> = moshi.adapter(Type::class.java, emptySet(),
      "knownMoveType")

  private val nullableLocationAdapter: JsonAdapter<Location?> = moshi.adapter(Location::class.java,
      emptySet(), "location")

  private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
      moshi.adapter(Boolean::class.javaObjectType, emptySet(), "needsOverworldRain")

  private val nullableSpeciesAdapter: JsonAdapter<Species?> = moshi.adapter(Species::class.java,
      emptySet(), "partySpecies")

  private val nullableStringAdapter: JsonAdapter<String?> = moshi.adapter(String::class.java,
      emptySet(), "timeOfDay")

  private val nullableTriggerAdapter: JsonAdapter<Trigger?> = moshi.adapter(Trigger::class.java,
      emptySet(), "trigger")

  @Volatile
  private var constructorRef: Constructor<EvolutionDetail>? = null

  public override fun toString(): String = buildString(37) {
      append("GeneratedJsonAdapter(").append("EvolutionDetail").append(')') }

  public override fun fromJson(reader: JsonReader): EvolutionDetail {
    var gender: Int? = null
    var heldItem: HeldItem? = null
    var item: Item? = null
    var knownMove: Move? = null
    var knownMoveType: Type? = null
    var location: Location? = null
    var minAffection: Int? = null
    var minBeauty: Int? = null
    var minHappiness: Int? = null
    var minLevel: Int? = null
    var needsOverworldRain: Boolean? = null
    var partySpecies: Species? = null
    var partyType: Type? = null
    var relativePhysicalStats: Int? = null
    var timeOfDay: String? = null
    var tradeSpecies: Species? = null
    var trigger: Trigger? = null
    var turnUpsideDown: Boolean? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          gender = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          heldItem = nullableHeldItemAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        2 -> {
          item = nullableItemAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 2).inv()
          mask0 = mask0 and 0xfffffffb.toInt()
        }
        3 -> {
          knownMove = nullableMoveAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 3).inv()
          mask0 = mask0 and 0xfffffff7.toInt()
        }
        4 -> {
          knownMoveType = nullableTypeAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 4).inv()
          mask0 = mask0 and 0xffffffef.toInt()
        }
        5 -> {
          location = nullableLocationAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 5).inv()
          mask0 = mask0 and 0xffffffdf.toInt()
        }
        6 -> {
          minAffection = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 6).inv()
          mask0 = mask0 and 0xffffffbf.toInt()
        }
        7 -> {
          minBeauty = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 7).inv()
          mask0 = mask0 and 0xffffff7f.toInt()
        }
        8 -> {
          minHappiness = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 8).inv()
          mask0 = mask0 and 0xfffffeff.toInt()
        }
        9 -> {
          minLevel = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 9).inv()
          mask0 = mask0 and 0xfffffdff.toInt()
        }
        10 -> {
          needsOverworldRain = nullableBooleanAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 10).inv()
          mask0 = mask0 and 0xfffffbff.toInt()
        }
        11 -> {
          partySpecies = nullableSpeciesAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 11).inv()
          mask0 = mask0 and 0xfffff7ff.toInt()
        }
        12 -> {
          partyType = nullableTypeAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 12).inv()
          mask0 = mask0 and 0xffffefff.toInt()
        }
        13 -> {
          relativePhysicalStats = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 13).inv()
          mask0 = mask0 and 0xffffdfff.toInt()
        }
        14 -> {
          timeOfDay = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 14).inv()
          mask0 = mask0 and 0xffffbfff.toInt()
        }
        15 -> {
          tradeSpecies = nullableSpeciesAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 15).inv()
          mask0 = mask0 and 0xffff7fff.toInt()
        }
        16 -> {
          trigger = nullableTriggerAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 16).inv()
          mask0 = mask0 and 0xfffeffff.toInt()
        }
        17 -> {
          turnUpsideDown = nullableBooleanAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 17).inv()
          mask0 = mask0 and 0xfffdffff.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfffc0000.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  EvolutionDetail(
          gender = gender,
          heldItem = heldItem,
          item = item,
          knownMove = knownMove,
          knownMoveType = knownMoveType,
          location = location,
          minAffection = minAffection,
          minBeauty = minBeauty,
          minHappiness = minHappiness,
          minLevel = minLevel,
          needsOverworldRain = needsOverworldRain,
          partySpecies = partySpecies,
          partyType = partyType,
          relativePhysicalStats = relativePhysicalStats,
          timeOfDay = timeOfDay,
          tradeSpecies = tradeSpecies,
          trigger = trigger,
          turnUpsideDown = turnUpsideDown
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<EvolutionDetail> = this.constructorRef ?:
          EvolutionDetail::class.java.getDeclaredConstructor(Int::class.javaObjectType,
          HeldItem::class.java, Item::class.java, Move::class.java, Type::class.java,
          Location::class.java, Int::class.javaObjectType, Int::class.javaObjectType,
          Int::class.javaObjectType, Int::class.javaObjectType, Boolean::class.javaObjectType,
          Species::class.java, Type::class.java, Int::class.javaObjectType, String::class.java,
          Species::class.java, Trigger::class.java, Boolean::class.javaObjectType,
          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {
          this.constructorRef = it }
      return localConstructor.newInstance(
          gender,
          heldItem,
          item,
          knownMove,
          knownMoveType,
          location,
          minAffection,
          minBeauty,
          minHappiness,
          minLevel,
          needsOverworldRain,
          partySpecies,
          partyType,
          relativePhysicalStats,
          timeOfDay,
          tradeSpecies,
          trigger,
          turnUpsideDown,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: EvolutionDetail?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("gender")
    nullableIntAdapter.toJson(writer, value_.gender)
    writer.name("held_item")
    nullableHeldItemAdapter.toJson(writer, value_.heldItem)
    writer.name("item")
    nullableItemAdapter.toJson(writer, value_.item)
    writer.name("known_move")
    nullableMoveAdapter.toJson(writer, value_.knownMove)
    writer.name("known_move_type")
    nullableTypeAdapter.toJson(writer, value_.knownMoveType)
    writer.name("location")
    nullableLocationAdapter.toJson(writer, value_.location)
    writer.name("min_affection")
    nullableIntAdapter.toJson(writer, value_.minAffection)
    writer.name("min_beauty")
    nullableIntAdapter.toJson(writer, value_.minBeauty)
    writer.name("min_happiness")
    nullableIntAdapter.toJson(writer, value_.minHappiness)
    writer.name("min_level")
    nullableIntAdapter.toJson(writer, value_.minLevel)
    writer.name("needs_overworld_rain")
    nullableBooleanAdapter.toJson(writer, value_.needsOverworldRain)
    writer.name("party_species")
    nullableSpeciesAdapter.toJson(writer, value_.partySpecies)
    writer.name("party_type")
    nullableTypeAdapter.toJson(writer, value_.partyType)
    writer.name("relative_physical_stats")
    nullableIntAdapter.toJson(writer, value_.relativePhysicalStats)
    writer.name("time_of_day")
    nullableStringAdapter.toJson(writer, value_.timeOfDay)
    writer.name("trade_species")
    nullableSpeciesAdapter.toJson(writer, value_.tradeSpecies)
    writer.name("trigger")
    nullableTriggerAdapter.toJson(writer, value_.trigger)
    writer.name("turn_upside_down")
    nullableBooleanAdapter.toJson(writer, value_.turnUpsideDown)
    writer.endObject()
  }
}
