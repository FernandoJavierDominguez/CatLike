package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {

    @Insert
    suspend fun addBreed(breed: Breed)

    @Insert
    suspend fun addBreeds(breeds: List<Breed>)

    @Query("SELECT * FROM Breed")
    fun getAllBreeds() : Flow<List<Breed>>

    @Transaction @Query("SELECT * FROM Breed")
    fun getAllBreedWithLikes() : Flow<List<BreedWithLikes>>

   /*@Query("SELECT * FROM Breed")
   suspend fun getAllBreeds() : List<Breed>*/

    @Query("SELECT * FROM Breed WHERE id=:id")
    suspend fun getBreedById(id: String) : Breed

    @Query("SELECT COUNT(id) FROM Breed")
    suspend fun breedCount(): Int

    @Query("DELETE FROM Breed")
    suspend fun deleteAll()

}