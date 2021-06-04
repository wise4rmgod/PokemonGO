package com.dev.pokemongo.repository

import com.example.urlshortenapp.retrofit.ApiService
import com.example.urlshortenapp.retrofit.RetrofitClient

class CapturedRepository {
    var client: ApiService = RetrofitClient.retrofit

    suspend fun getCaptured(token: String) = client.getcaptured(token)
}