package com.kobeissidev.jetpackcomposepokedex.data.model.entry

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity(tableName = "pokemon_entry")
@JsonClass(generateAdapter = true)
@Parcelize
data class PokemonEntry(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>,
    @PrimaryKey
    var id: Int = -1
) : Parcelable