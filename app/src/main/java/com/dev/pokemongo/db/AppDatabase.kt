package com.dev.pokemongo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.pokemongo.retrofit.request.Pokemon
import com.dev.pokemongo.retrofit.response.CaptureResponse
import com.dev.pokemongo.retrofit.response.CapturedResponse
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.dev.pokemongo.retrofit.response.communityresponse.CommunityResponse


@Database(
    entities = arrayOf(
        CapturedResponse::class,
        MyteamResponse::class,
        Pokemon::class
    ), version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemon(): PokemonDao
}