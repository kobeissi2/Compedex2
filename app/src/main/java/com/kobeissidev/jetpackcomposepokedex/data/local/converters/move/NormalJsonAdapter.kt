// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kobeissidev.jetpackcomposepokedex.data.local.converters.move

import com.kobeissidev.jetpackcomposepokedex.data.model.move.Normal
import com.kobeissidev.jetpackcomposepokedex.data.model.move.UseBefore
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.`internal`.Util
import java.lang.NullPointerException
import java.lang.reflect.Constructor
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.emptySet
import kotlin.jvm.Volatile
import kotlin.text.buildString

public class NormalJsonAdapter(
  moshi: Moshi
) : JsonAdapter<Normal>() {
  private val options: JsonReader.Options = JsonReader.Options.of("use_after", "use_before")

  private val nullableStringAdapter: JsonAdapter<String?> = moshi.adapter(String::class.java,
      emptySet(), "useAfter")

  private val listOfUseBeforeAdapter: JsonAdapter<List<UseBefore>> =
      moshi.adapter(Types.newParameterizedType(List::class.java, UseBefore::class.java), emptySet(),
      "useBefore")

  @Volatile
  private var constructorRef: Constructor<Normal>? = null

  public override fun toString(): String = buildString(28) {
      append("GeneratedJsonAdapter(").append("Normal").append(')') }

  public override fun fromJson(reader: JsonReader): Normal {
    var useAfter: String? = null
    var useBefore: List<UseBefore>? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          useAfter = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        1 -> {
          useBefore = listOfUseBeforeAdapter.fromJson(reader) ?:
              throw Util.unexpectedNull("useBefore", "use_before", reader)
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
      return  Normal(
          useAfter = useAfter,
          useBefore = useBefore as List<UseBefore>
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<Normal> = this.constructorRef ?:
          Normal::class.java.getDeclaredConstructor(String::class.java, List::class.java,
          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {
          this.constructorRef = it }
      return localConstructor.newInstance(
          useAfter,
          useBefore,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: Normal?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("use_after")
    nullableStringAdapter.toJson(writer, value_.useAfter)
    writer.name("use_before")
    listOfUseBeforeAdapter.toJson(writer, value_.useBefore)
    writer.endObject()
  }
}