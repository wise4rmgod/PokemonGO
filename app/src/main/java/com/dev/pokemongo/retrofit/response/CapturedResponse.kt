package com.dev.pokemongo.retrofit.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "captured")
data class CapturedResponse(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var captured_at: String? = null,
    var captured_lat_at: Double? = null,
    var name: String? = null,
    var captured_long_at: Double? = null
)