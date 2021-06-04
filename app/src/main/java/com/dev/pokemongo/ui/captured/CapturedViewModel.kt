package com.dev.pokemongo.ui.captured

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.dev.pokemongo.repository.CapturedRepository
import com.dev.pokemongo.repository.MyTeamRepository
import com.dev.pokemongo.retrofit.response.CapturedResponse
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.example.urlshortenapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CapturedViewModel @ViewModelInject constructor(private val capturedRepository: CapturedRepository) :
    ViewModel() {
    var getlocalCaptured: LiveData<List<CapturedResponse>> = capturedRepository.getlocalCaptured()

    fun getCaptured(token: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            //  mainRepository.getCaptured(token).
            emit(Resource.success(data = capturedRepository.getCaptured(token)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun saveCaptured(capturedResponse: CapturedResponse) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                capturedRepository.addlocalCaptured(capturedResponse)
            }
        }
    }
}