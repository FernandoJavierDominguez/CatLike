package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BreedDao {

    @Insert
    suspend fun addBreed(breed: Breed)

    @Query("SELECT * FROM Breed")
    suspend fun getAllBreeds() : List<Breed>

    @Query("SELECT * FROM Breed WHERE id=:id")
    suspend fun getBreedById(id: String) : Breed
}