package com.fernandodominguezpacheco.data.datasource

import com.fernandodominguezpacheco.domain.Breed

interface LocalBreedDataSource {
    suspend fun addBreed(breed: Breed)
    suspend fun getAllBreeds() : List<Breed>
    suspend fun getBreedById() : List<Breed>
}