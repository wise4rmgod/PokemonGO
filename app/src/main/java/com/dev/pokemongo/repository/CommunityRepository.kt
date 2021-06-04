package com.dev.pokemongo.repository

import com.dev.pokemongo.retrofit.ApiService
import com.example.urlshortenapp.retrofit.RetrofitClient

class CommunityRepository {
    var client: ApiService = RetrofitClient.retrofit

    suspend fun getCommunity(token: String) = client.getcummunity(token)
}