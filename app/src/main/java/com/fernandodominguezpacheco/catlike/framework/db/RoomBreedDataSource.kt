package com.fernandodominguezpacheco.catlike.framework.db

import com.fernandodominguezpacheco.catlike.framework.toBreed
import com.fernandodominguezpacheco.catlike.framework.toRoomBreed
import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.domain.Breed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RoomBreedDataSource(db: BreedDb) : LocalBreedDataSource {

    private val breedDao = db.breedDao()

    override suspend fun addBreed(breed: Breed) {
        withContext(Dispatchers.IO){
            breedDao.addBreed(breed.toRoomBreed())
        }
    }

    override suspend fun addBreeds(breeds: List<Breed>) {
        breedDao.addBreeds(breeds.map{ it.toRoomBreed()})
    }

    /*override suspend fun getAllBreeds(): List<Breed> {
        return breedDao.getAllBreeds().map { it.toBreed() }
    }*/

    override fun getAllBreeds(): Flow<List<Breed>> = breedDao.getAllBreeds().map {
        breeds -> breeds.map { it.toBreed() }
    }
    override fun getAllBreedWithLikes(): Flow<List<Breed>> {
        return breedDao.getAllBreedWithLikes().map {
            breeds -> breeds.map { it.toBreed() }
        }
    }



    override suspend fun getBreedById(id: String): Breed  = withContext(Dispatchers.IO){
        breedDao.getBreedById(id).toBreed()
    }

    override suspend fun isEmpty(): Boolean = breedDao.breedCount() <= 0


    override suspend fun deleteAll() {
        breedDao.deleteAll()
    }


}