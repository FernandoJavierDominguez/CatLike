package com.fernandodominguezpacheco.data.repository

import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.data.datasource.RemoteBreedDataSource
import com.fernandodominguezpacheco.domain.Breed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import sun.rmi.runtime.Log
import sun.rmi.runtime.Log.VERBOSE
import java.rmi.server.LogStream.VERBOSE
import java.util.logging.Logger


class BreedRepository(private val localBreedDataSource: LocalBreedDataSource, private val remoteBreedDataSource: RemoteBreedDataSource, private val likeDataSource: LikeDataSource) {

    suspend fun addBreed(breed: Breed) = localBreedDataSource.addBreed(breed)

    //fun getAllBreeds() : Flow<List<Breed>> = localBreedDataSource.getAllBreeds()
    /*suspend fun getAllBreeds() : List<Breed>{
        return if(localBreedDataSource.isEmpty()){
            localBreedDataSource.addBreeds(remoteBreedDataSource.getAllBreeds())
            localBreedDataSource.getAllBreeds()
        } else{
            localBreedDataSource.getAllBreeds()
        }
}*/
    /*fun getAllBreeds() : Flow<List<Breed>> = if(localBreedDataSource.isEmpty()){
        localBreedDataSource.addBreeds(remoteBreedDataSource.getAllBreeds())
        localBreedDataSource.getAllBreeds()
    } else{
        localBreedDataSource.getAllBreeds()
    }*/

    //fun getAllBreeds() : Flow<List<Breed>> = localBreedDataSource.getAllBreeds()

    fun getAllBreeds() : Flow<List<Breed>>{
        //val breeds = localBreedDataSource.getAllBreeds()
        val breeds = localBreedDataSource.getAllBreedWithLikes()
        /*breeds.map { breeds -> breeds.forEach {
                it.like = likeDataSource.getLikeByBreed(it.id).toList().isEmpty()
            }
        }*/
        return breeds
    }
    suspend fun addCacheBreed() {
        if(localBreedDataSource.isEmpty()) {
            localBreedDataSource.addBreeds(remoteBreedDataSource.getAllBreeds())
            localBreedDataSource.getAllBreeds()
        }
    }



    suspend fun getBreedById(id: String) : Breed = localBreedDataSource.getBreedById(id)

}