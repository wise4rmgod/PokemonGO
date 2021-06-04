package com.dev.pokemongo.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dev.pokemongo.retrofit.request.Pokemon
import com.dev.pokemongo.retrofit.response.CaptureResponse
import com.dev.pokemongo.retrofit.response.CapturedResponse
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.dev.pokemongo.retrofit.response.communityresponse.CommunityResponse

@Dao
interface PokemonDao {
    @Query("SELECT * FROM myteam")
    fun showallteam(): LiveData<List<MyteamResponse>>

    @Query("SELECT * FROM captured")
    fun showallcaptured(): LiveData<List<CapturedResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(myteamResponse: MyteamResponse?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCaptured(capturedResponse: CapturedResponse?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCapture(pokemon: Pokemon?)

    /**  @Delete
    fun delete(ovmedia: OVMedia) **/
}