package com.dev.pokemongo.ui.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.pokemongo.repository.CapturedRepository
import com.dev.pokemongo.repository.CommunityRepository
import com.example.urlshortenapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class CommunityViewModel : ViewModel() {
    var mainRepository: CommunityRepository = CommunityRepository()
    fun getCommunity(token: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getCommunity(token)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}