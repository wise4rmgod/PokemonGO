package com.dev.pokemongo.retrofit.request

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "capture")
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var lat: Double? = null,
    var long: Double? = null

)