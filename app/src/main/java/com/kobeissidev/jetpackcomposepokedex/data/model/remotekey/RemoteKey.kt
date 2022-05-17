package com.kobeissidev.jetpackcomposepokedex.data.model.remotekey

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "remote_key")
@JsonClass(generateAdapter = true)
data class RemoteKey(
    @PrimaryKey val id: String,
    val prevKey: Int?,
    val nextKey: Int?
)