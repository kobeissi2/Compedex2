// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.pokemon

import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.*
import com.kobeissidev.jetpackcomposepokedex.data.model.supplementary.Palette
import com.squareup.moshi.*
import com.squareup.moshi.internal.Util
import java.lang.reflect.Constructor
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public class PokemonJsonAdapter(
  moshi: Moshi
) : JsonAdapter<Pokemon>() {
  private val options: JsonReader.Options = JsonReader.Options.of("abilities", "base_experience",
      "forms", "game_indices", "height", "held_items", "id", "is_default",
      "location_area_encounters", "moves", "name", "order", "past_types", "species", "sprites",
      "stats", "types", "weight", "paletteList")

  private val nullableListOfAbilityAdapter: JsonAdapter<List<Ability>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, Ability::class.java), emptySet(),
      "abilities")

  private val nullableIntAdapter: JsonAdapter<Int?> = moshi.adapter(Int::class.javaObjectType,
      emptySet(), "baseExperience")

  private val nullableListOfFormAdapter: JsonAdapter<List<Form>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, Form::class.java), emptySet(),
      "forms")

  private val nullableListOfGameIndiceAdapter: JsonAdapter<List<GameIndice>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, GameIndice::class.java),
      emptySet(), "gameIndices")

  private val nullableListOfHeldItemAdapter: JsonAdapter<List<HeldItem>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, HeldItem::class.java), emptySet(),
      "heldItems")

  private val intAdapter: JsonAdapter<Int> = moshi.adapter(Int::class.java, emptySet(), "id")

  private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
      moshi.adapter(Boolean::class.javaObjectType, emptySet(), "isDefault")

  private val nullableStringAdapter: JsonAdapter<String?> = moshi.adapter(String::class.java,
      emptySet(), "locationAreaEncounters")

  private val nullableListOfMoveAdapter: JsonAdapter<List<Move>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, Move::class.java), emptySet(),
      "moves")

  private val stringAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, emptySet(),
      "originalName")

  private val nullableListOfTypeAdapter: JsonAdapter<List<Type>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, Type::class.java), emptySet(),
      "pastTypes")

  private val nullableSpeciesAdapter: JsonAdapter<Species?> = moshi.adapter(Species::class.java,
      emptySet(), "species")

  private val nullableSpritesAdapter: JsonAdapter<Sprites?> = moshi.adapter(Sprites::class.java,
      emptySet(), "sprites")

  private val nullableListOfStatAdapter: JsonAdapter<List<Stat>?> =
      moshi.adapter(Types.newParameterizedType(List::class.java, Stat::class.java), emptySet(),
      "stats")

  private val listOfPaletteAdapter: JsonAdapter<List<Palette>> =
      moshi.adapter(Types.newParameterizedType(List::class.java, Palette::class.java), emptySet(),
      "paletteList")

  @Volatile
  private var constructorRef: Constructor<Pokemon>? = null

  public override fun toString(): String = buildString(29) {
      append("GeneratedJsonAdapter(").append("Pokemon").append(')') }

  public override fun fromJson(reader: JsonReader): Pokemon {
    var abilities: List<Ability>? = null
    var baseExperience: Int? = null
    var forms: List<Form>? = null
    var gameIndices: List<GameIndice>? = null
    var height: Int? = null
    var heldItems: List<HeldItem>? = null
    var id: Int? = null
    var isDefault: Boolean? = null
    var locationAreaEncounters: String? = null
    var moves: List<Move>? = null
    var originalName: String? = null
    var order: Int? = null
    var pastTypes: List<Type>? = null
    var species: Species? = null
    var sprites: Sprites? = null
    var stats: List<Stat>? = null
    var types_: List<Type>? = null
    var weight: Int? = null
    var paletteList: List<Palette>? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          abilities = nullableListOfAbilityAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          baseExperience = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 1).inv()
          mask0 = mask0 and 0xfffffffd.toInt()
        }
        2 -> {
          forms = nullableListOfFormAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 2).inv()
          mask0 = mask0 and 0xfffffffb.toInt()
        }
        3 -> {
          gameIndices = nullableListOfGameIndiceAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 3).inv()
          mask0 = mask0 and 0xfffffff7.toInt()
        }
        4 -> {
          height = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 4).inv()
          mask0 = mask0 and 0xffffffef.toInt()
        }
        5 -> {
          heldItems = nullableListOfHeldItemAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 5).inv()
          mask0 = mask0 and 0xffffffdf.toInt()
        }
        6 -> id = intAdapter.fromJson(reader) ?: throw Util.unexpectedNull("id", "id", reader)
        7 -> {
          isDefault = nullableBooleanAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 7).inv()
          mask0 = mask0 and 0xffffff7f.toInt()
        }
        8 -> {
          locationAreaEncounters = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 8).inv()
          mask0 = mask0 and 0xfffffeff.toInt()
        }
        9 -> {
          moves = nullableListOfMoveAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 9).inv()
          mask0 = mask0 and 0xfffffdff.toInt()
        }
        10 -> originalName = stringAdapter.fromJson(reader) ?:
            throw Util.unexpectedNull("originalName", "name", reader)
        11 -> {
          order = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 11).inv()
          mask0 = mask0 and 0xfffff7ff.toInt()
        }
        12 -> {
          pastTypes = nullableListOfTypeAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 12).inv()
          mask0 = mask0 and 0xffffefff.toInt()
        }
        13 -> {
          species = nullableSpeciesAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 13).inv()
          mask0 = mask0 and 0xffffdfff.toInt()
        }
        14 -> {
          sprites = nullableSpritesAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 14).inv()
          mask0 = mask0 and 0xffffbfff.toInt()
        }
        15 -> {
          stats = nullableListOfStatAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 15).inv()
          mask0 = mask0 and 0xffff7fff.toInt()
        }
        16 -> {
          types_ = nullableListOfTypeAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 16).inv()
          mask0 = mask0 and 0xfffeffff.toInt()
        }
        17 -> {
          weight = nullableIntAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 17).inv()
          mask0 = mask0 and 0xfffdffff.toInt()
        }
        18 -> {
          paletteList = listOfPaletteAdapter.fromJson(reader) ?:
              throw Util.unexpectedNull("paletteList", "paletteList", reader)
          // $mask = $mask and (1 shl 18).inv()
          mask0 = mask0 and 0xfffbffff.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfff80440.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  Pokemon(
          abilities = abilities,
          baseExperience = baseExperience,
          forms = forms,
          gameIndices = gameIndices,
          height = height,
          heldItems = heldItems,
          id = id ?: throw Util.missingProperty("id", "id", reader),
          isDefault = isDefault,
          locationAreaEncounters = locationAreaEncounters,
          moves = moves,
          originalName = originalName ?: throw Util.missingProperty("originalName", "name", reader),
          order = order,
          pastTypes = pastTypes,
          species = species,
          sprites = sprites,
          stats = stats,
          types = types_,
          weight = weight,
          paletteList = paletteList as List<Palette>
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<Pokemon> = this.constructorRef ?:
          Pokemon::class.java.getDeclaredConstructor(List::class.java, Int::class.javaObjectType,
          List::class.java, List::class.java, Int::class.javaObjectType, List::class.java,
          Int::class.javaPrimitiveType, Boolean::class.javaObjectType, String::class.java,
          List::class.java, String::class.java, Int::class.javaObjectType, List::class.java,
          Species::class.java, Sprites::class.java, List::class.java, List::class.java,
          Int::class.javaObjectType, List::class.java, Int::class.javaPrimitiveType,
          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }
      return localConstructor.newInstance(
          abilities,
          baseExperience,
          forms,
          gameIndices,
          height,
          heldItems,
          id ?: throw Util.missingProperty("id", "id", reader),
          isDefault,
          locationAreaEncounters,
          moves,
          originalName ?: throw Util.missingProperty("originalName", "name", reader),
          order,
          pastTypes,
          species,
          sprites,
          stats,
          types_,
          weight,
          paletteList,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: Pokemon?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("abilities")
    nullableListOfAbilityAdapter.toJson(writer, value_.abilities)
    writer.name("base_experience")
    nullableIntAdapter.toJson(writer, value_.baseExperience)
    writer.name("forms")
    nullableListOfFormAdapter.toJson(writer, value_.forms)
    writer.name("game_indices")
    nullableListOfGameIndiceAdapter.toJson(writer, value_.gameIndices)
    writer.name("height")
    nullableIntAdapter.toJson(writer, value_.height)
    writer.name("held_items")
    nullableListOfHeldItemAdapter.toJson(writer, value_.heldItems)
    writer.name("id")
    intAdapter.toJson(writer, value_.id)
    writer.name("is_default")
    nullableBooleanAdapter.toJson(writer, value_.isDefault)
    writer.name("location_area_encounters")
    nullableStringAdapter.toJson(writer, value_.locationAreaEncounters)
    writer.name("moves")
    nullableListOfMoveAdapter.toJson(writer, value_.moves)
    writer.name("name")
    stringAdapter.toJson(writer, value_.originalName)
    writer.name("order")
    nullableIntAdapter.toJson(writer, value_.order)
    writer.name("past_types")
    nullableListOfTypeAdapter.toJson(writer, value_.pastTypes)
    writer.name("species")
    nullableSpeciesAdapter.toJson(writer, value_.species)
    writer.name("sprites")
    nullableSpritesAdapter.toJson(writer, value_.sprites)
    writer.name("stats")
    nullableListOfStatAdapter.toJson(writer, value_.stats)
    writer.name("types")
    nullableListOfTypeAdapter.toJson(writer, value_.types)
    writer.name("weight")
    nullableIntAdapter.toJson(writer, value_.weight)
    writer.name("paletteList")
    listOfPaletteAdapter.toJson(writer, value_.paletteList)
    writer.endObject()
  }
}
