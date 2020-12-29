package com.fernandodominguezpacheco.data.datasource

import com.fernandodominguezpacheco.domain.Breed

interface LocalBreedDataSource {
    suspend fun addBreed(breed: Breed)
    suspend fun addBreeds(breeds: List<Breed>)
    suspend fun getAllBreeds() : List<Breed>
    suspend fun getAllBreedWithLikes() : List<Breed>
    suspend fun getBreedById(id: String) : Breed
    suspend fun isEmpty(): Boolean
    suspend fun deleteAll()
}