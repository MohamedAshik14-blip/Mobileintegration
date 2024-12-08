package com.example.petapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pets")
data class Pet(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val caloriesBurned: Int,
    val latitude: Double,
    val longitude: Double
)
