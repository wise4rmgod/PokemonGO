package com.dev.pokemongo.repository

import androidx.lifecycle.LiveData
import com.dev.pokemongo.db.AppDatabase
import com.dev.pokemongo.retrofit.response.CapturedResponse
import com.dev.pokemongo.retrofit.ApiService
import com.example.urlshortenapp.retrofit.RetrofitClient
import javax.inject.Inject

class CapturedRepository @Inject constructor(appDatabase: AppDatabase) {
    private val pokemonDao = appDatabase.pokemon()
    var client: ApiService = RetrofitClient.retrofit

    suspend fun getCaptured(token: String) = client.getcaptured(token)

    fun getlocalCaptured(): LiveData<List<CapturedResponse>> {
        return pokemonDao.showallcaptured()
    }

    fun addlocalCaptured(capturedResponse: CapturedResponse) {
        pokemonDao.insertCaptured(capturedResponse)
    }
}