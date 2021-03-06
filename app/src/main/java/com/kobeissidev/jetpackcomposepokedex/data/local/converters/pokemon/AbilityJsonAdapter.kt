// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Ability
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.AbilityX
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.internal.Util
import java.lang.reflect.Constructor
import kotlin.Boolean
import kotlin.Int

public class AbilityJsonAdapter(
  moshi: Moshi
) : JsonAdapter<Ability>() {
  private val options: JsonReader.Options = JsonReader.Options.of("ability", "is_hidden", "slot")

  private val nullableAbilityXAdapter: JsonAdapter<AbilityX?> = moshi.adapter(AbilityX::class.java,
      emptySet(), "ability")

  private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
      moshi.adapter(Boolean::class.javaObjectType, emptySet(), "isHidden")

  private val nullableIntAdapter: JsonAdapter<Int?> = moshi.adapter(Int::class.javaObjectType,
      emptySet(), "slot")

  @Volatile
  private var constructorRef: Constructor<Ability>? = null

  public override fun toString(): String = buildString(29) {
      append("GeneratedJsonAdapter(").append("Ability").append(')') }

  public override fun fromJson(reader: JsonReader): Ability {
    var ability: AbilityX? = null
    var isHidden: Boolean? = null
    var slot: Int? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          ability = nullableAbilityXAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          isHidden = nullableBooleanAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        2 -> {
          slot = nullableIntAdapter.fromJson(reader)
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
      return  Ability(
          ability = ability,
          isHidden = isHidden,
          slot = slot
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<Ability> = this.constructorRef ?:
          Ability::class.java.getDeclaredConstructor(AbilityX::class.java,
          Boolean::class.javaObjectType, Int::class.javaObjectType, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          ability,
          isHidden,
          slot,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: Ability?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("ability")
    nullableAbilityXAdapter.toJson(writer, value_.ability)
    writer.name("is_hidden")
    nullableBooleanAdapter.toJson(writer, value_.isHidden)
    writer.name("slot")
    nullableIntAdapter.toJson(writer, value_.slot)
    writer.endObject()
  }
}
