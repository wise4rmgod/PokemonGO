package com.example.urlshortenapp.retrofit

import com.dev.pokemongo.retrofit.ApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://us-central1-samaritan-android-assignment.cloudfunctions.net")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ApiService::class.java)
    }
}
