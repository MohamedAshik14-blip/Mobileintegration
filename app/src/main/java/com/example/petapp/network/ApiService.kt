package com.example.petapp.network

import com.example.petapp.model.Pet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("api/pets")
    fun getPets(@Header("Authorization") token: String?): Call<List<Pet>>
}
