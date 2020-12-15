package com.fernandodominguezpacheco.data.repository

import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.domain.Breed

class BreedRepository(private val localBreedDataSource: LocalBreedDataSource) {

    suspend fun addBreed(breed: Breed) = localBreedDataSource.addBreed(breed)
    suspend fun getAllBreeds() : List<Breed> = localBreedDataSource.getAllBreeds()
    suspend fun getBreedById() : List<Breed> = localBreedDataSource.getBreedById()

}