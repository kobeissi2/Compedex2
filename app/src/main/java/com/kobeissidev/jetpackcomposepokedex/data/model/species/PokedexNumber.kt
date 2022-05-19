package com.kobeissidev.jetpackcomposepokedex.data.model.species

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class PokedexNumber(
    @Json(name = "entry_number")
    val entryNumber: Int = 0,
    @Json(name = "pokedex")
    val pokedex: Pokedex = Pokedex()
) : Parcelable