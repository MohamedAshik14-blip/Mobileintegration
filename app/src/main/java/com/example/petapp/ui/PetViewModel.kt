package com.example.petapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petapp.model.Pet
import com.example.petapp.network.PetApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PetViewModel : ViewModel() {


    private val _pets = MutableStateFlow<List<Pet>>(emptyList())
    val pets: StateFlow<List<Pet>> = _pets


    private val petApiService = PetApiService.create()


    init {
        fetchPets()
    }

    private fun fetchPets() {
        viewModelScope.launch {
            try {
                val petsFromApi = petApiService.getPets()
                _pets.value = petsFromApi
                Log.d("PetViewModel", "Successfully fetched pets: ${petsFromApi.size}")
            } catch (e: Exception) {
                Log.e("PetViewModel", "Error fetching pets", e)
            }
        }
    }
}
