package com.kobeissidev.jetpackcomposepokedex.data.model.pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class VersionGroupDetail(
    @Json(name = "level_learned_at") val levelLearnedAt: Int? = null,
    @Json(name = "move_learn_method") val moveLearnMethod: MoveLearnMethod? = null,
    @Json(name = "version_group") val versionGroup: VersionGroup? = null
) : Parcelable {

    val levelToDisplay
        get() = if (levelLearnedAt != 0) {
            "@ LVL$levelLearnedAt"
        } else null

}