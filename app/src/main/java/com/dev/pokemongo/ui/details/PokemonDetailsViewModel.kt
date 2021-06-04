package com.dev.pokemongo.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.pokemongo.repository.CaptureRepository
import com.dev.pokemongo.retrofit.request.GetPokemon
import com.example.urlshortenapp.utils.Resource
import kotlinx.coroutines.Dispatchers


class PokemonDetailsViewModel @ViewModelInject constructor(private val captureRepository: CaptureRepository) :
    ViewModel() {
    fun CapturePokemon(token: String, getPokemon: GetPokemon) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            //  mainRepository.getCaptured(token).
            emit(Resource.success(data = captureRepository.Capture(token, getPokemon)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}