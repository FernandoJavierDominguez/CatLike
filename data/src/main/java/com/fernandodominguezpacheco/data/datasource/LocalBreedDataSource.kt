package com.fernandodominguezpacheco.data.datasource

import com.fernandodominguezpacheco.domain.Breed
import kotlinx.coroutines.flow.Flow

interface LocalBreedDataSource {
    suspend fun addBreed(breed: Breed)
    suspend fun addBreeds(breeds: List<Breed>)
    fun getAllBreeds() : Flow<List<Breed>>
    fun getAllBreedWithLikes() : Flow<List<Breed>>
    suspend fun getBreedById(id: String) : Breed
    suspend fun isEmpty(): Boolean
    suspend fun deleteAll()
}