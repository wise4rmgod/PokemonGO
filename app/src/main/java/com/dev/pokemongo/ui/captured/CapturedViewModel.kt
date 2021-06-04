package com.dev.pokemongo.ui.captured

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.pokemongo.repository.CapturedRepository
import com.dev.pokemongo.repository.MyTeamRepository
import com.example.urlshortenapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class CapturedViewModel : ViewModel() {
    var mainRepository: CapturedRepository = CapturedRepository()
    fun getCaptured(token: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            //  mainRepository.getCaptured(token).
            emit(Resource.success(data = mainRepository.getCaptured(token)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun addCaptured() {

    }
}