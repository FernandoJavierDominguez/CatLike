package com.fernandodominguezpacheco.data.repository

import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.data.datasource.RemoteBreedDataSource
import com.fernandodominguezpacheco.domain.Breed
import kotlinx.coroutines.flow.Flow


class BreedRepository(private val localBreedDataSource: LocalBreedDataSource, private val remoteBreedDataSource: RemoteBreedDataSource, private val likeDataSource: LikeDataSource) {

    suspend fun addBreed(breed: Breed) = localBreedDataSource.addBreed(breed)

    fun getAllBreeds() : Flow<List<Breed>> =  localBreedDataSource.getAllBreedWithLikes()

    suspend fun addCacheBreed() {
        if(localBreedDataSource.isEmpty()) {
            localBreedDataSource.addBreeds(remoteBreedDataSource.getAllBreeds())
            localBreedDataSource.getAllBreeds()
        }
    }

    suspend fun getBreedById(id: String) : Breed = localBreedDataSource.getBreedById(id)

}