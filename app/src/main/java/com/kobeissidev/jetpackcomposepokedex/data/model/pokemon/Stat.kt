package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.kobeissidev.jetpackcomposepokedex.util.removeDash
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Stat(
    @Json(name = "base_stat") val baseStat: Int? = null,
    val effort: Int? = null,
    val stat: StatX? = null
) : Parcelable {

    /**
     * Shorten the names of specific fields.
     */
    val nameShortened
        get() = when (val name = stat!!.name!!.removeDash) {
            HP -> HP.uppercase()
            SpecialAttack -> SpecialAttackShort
            SpecialDefense -> SpecialDefenseShort
            else -> name
        }

    private companion object {
        const val HP = "Hp"
        const val SpecialAttack = "Special Attack"
        const val SpecialDefense = "Special Defense"
        const val SpecialAttackShort = "Sp. Atk"
        const val SpecialDefenseShort = "Sp. Def"
    }
}