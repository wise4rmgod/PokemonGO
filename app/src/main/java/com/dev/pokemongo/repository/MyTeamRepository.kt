package com.dev.pokemongo.repository

import androidx.lifecycle.LiveData
import com.dev.pokemongo.db.AppDatabase
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.example.urlshortenapp.retrofit.ApiService
import com.example.urlshortenapp.retrofit.RetrofitClient
import javax.inject.Inject

class MyTeamRepository @Inject constructor(appDatabase: AppDatabase) {
    private val pokemonDao = appDatabase.pokemon()
    var client: ApiService = RetrofitClient.retrofit

    suspend fun getMyTeam(token: String) = client.getmyteam(token)
    fun getlocalTeam(): LiveData<List<MyteamResponse>> {
        return pokemonDao.showallteam()
    }

    fun addlocalTeam(myteamResponse: MyteamResponse) {
        pokemonDao.insertTeam(myteamResponse)
    }
}