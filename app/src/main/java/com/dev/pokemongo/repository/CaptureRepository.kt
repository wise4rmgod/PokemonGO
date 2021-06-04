package com.dev.pokemongo.repository

import com.dev.pokemongo.retrofit.request.GetPokemon
import com.dev.pokemongo.retrofit.ApiService
import com.example.urlshortenapp.retrofit.RetrofitClient
import javax.inject.Inject

class CaptureRepository @Inject constructor() {
    var client: ApiService = RetrofitClient.retrofit
    suspend fun Capture(token: String, getPokemon: GetPokemon) =
        client.capture(token, getPokemon)
}