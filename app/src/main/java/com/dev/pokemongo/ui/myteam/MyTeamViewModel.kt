package com.dev.pokemongo.ui.myteam

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dev.pokemongo.repository.ExploreRepository
import com.dev.pokemongo.repository.MyTeamRepository
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.example.urlshortenapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyTeamViewModel @ViewModelInject constructor(private val myTeamRepository: MyTeamRepository) :
    ViewModel() {

    var getloct: LiveData<List<MyteamResponse>> = myTeamRepository.getlocalTeam()
    fun getMyTeam(token: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = myTeamRepository.getMyTeam(token)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun saveTeam(myteamResponse: MyteamResponse) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                myTeamRepository.addlocalTeam(myteamResponse)
            }
        }
    }

}