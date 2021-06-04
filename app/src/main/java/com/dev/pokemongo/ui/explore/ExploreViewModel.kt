package com.dev.pokemongo.ui.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.pokemongo.repository.ExploreRepository
import com.example.urlshortenapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class ExploreViewModel : ViewModel() {
    var mainRepository: ExploreRepository = ExploreRepository()

    fun getToken() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getToken()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}