package com.example.petapp.network
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.petapp.model.Pet

@Dao
interface PetDao {

    @Insert
    suspend fun insertPet(pet: Pet)

    @Query("SELECT * FROM pets")
    suspend fun getAllPets(): List<Pet>
}
