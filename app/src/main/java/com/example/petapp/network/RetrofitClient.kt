package com.example.petapp.network

import com.example.petapp.model.Pet
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PetApiService {
    @GET("/pets")
    suspend fun getPets(): List<Pet>

    companion object {
        fun create(): PetApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://172.20.10.6:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PetApiService::class.java)
        }
    }
}