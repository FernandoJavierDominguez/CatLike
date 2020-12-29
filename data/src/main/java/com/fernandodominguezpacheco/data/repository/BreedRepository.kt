package com.fernandodominguezpacheco.data.repository

import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.data.datasource.RemoteBreedDataSource
import com.fernandodominguezpacheco.domain.Breed

class BreedRepository(private val localBreedDataSource: LocalBreedDataSource, private val remoteBreedDataSource: RemoteBreedDataSource, private val likeDataSource: LikeDataSource) {

    suspend fun addBreed(breed: Breed) = localBreedDataSource.addBreed(breed)

    suspend fun getAllBreeds() : List<Breed>{
        var breeds =  remoteBreedDataSource.getAllBreeds()
        if(localBreedDataSource.isEmpty()){
            localBreedDataSource.addBreeds(breeds)
        }
        breeds = localBreedDataSource.getAllBreedWithLikes()
        return breeds
    }
    suspend fun getAllBreedsRoom() : List<Breed> = localBreedDataSource.getAllBreedWithLikes()

    suspend fun getBreedById(id: String) : Breed = localBreedDataSource.getBreedById(id)

}