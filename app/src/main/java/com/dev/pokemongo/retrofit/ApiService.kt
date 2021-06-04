package com.dev.pokemongo.retrofit


import com.dev.pokemongo.retrofit.request.GetPokemon
import com.dev.pokemongo.retrofit.response.CaptureResponse
import com.dev.pokemongo.retrofit.response.CapturedResponse
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.dev.pokemongo.retrofit.response.Token
import com.dev.pokemongo.retrofit.response.communityresponse.CommunityResponse
import retrofit2.http.*

interface ApiService {
    @POST("token?")
    suspend fun getToken(
        @Query("email") email: String
    ): Token

    @GET("activity")
    suspend fun getcummunity(@Header("Authorization") token: String): CommunityResponse

    @GET("my-team")
    suspend fun getmyteam(@Header("Authorization") token: String): List<MyteamResponse>

    @GET("captured")
    suspend fun getcaptured(@Header("Authorization") token: String): List<CapturedResponse>

    @POST("capture")
    suspend fun capture(
        @Header("Authorization") token: String,
        @Body getPokemon: GetPokemon
    ): CaptureResponse
}