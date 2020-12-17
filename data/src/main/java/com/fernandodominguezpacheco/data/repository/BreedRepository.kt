package com.fernandodominguezpacheco.data.repository

import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.data.datasource.RemoteBreedDataSource
import com.fernandodominguezpacheco.domain.Breed

class BreedRepository(private val localBreedDataSource: LocalBreedDataSource, private val remoteBreedDataSource: RemoteBreedDataSource) {

    suspend fun addBreed(breed: Breed) = localBreedDataSource.addBreed(breed)

    suspend fun getAllBreeds() : List<Breed>{
        //return emptyList()
        return remoteBreedDataSource.getAllBreeds()
    }
    suspend fun getBreedById(id: String) : Breed = localBreedDataSource.getBreedById(id)

}