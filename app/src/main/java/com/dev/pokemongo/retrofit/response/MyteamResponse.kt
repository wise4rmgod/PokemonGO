package com.dev.pokemongo.retrofit.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myteam")
data class MyteamResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val captured_at: String,
    val captured_lat_at: Double,
    val name: String,
    val captured_long_at: Double
)