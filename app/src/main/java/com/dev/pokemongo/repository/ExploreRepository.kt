package com.dev.pokemongo.repository

import com.example.urlshortenapp.retrofit.ApiService
import com.example.urlshortenapp.retrofit.RetrofitClient

class ExploreRepository {
    var client: ApiService = RetrofitClient.retrofit
    suspend fun getToken() = client.getToken("wise4rmgod@gmail.com")
}