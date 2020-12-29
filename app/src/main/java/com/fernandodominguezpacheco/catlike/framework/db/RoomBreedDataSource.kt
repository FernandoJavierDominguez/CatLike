package com.fernandodominguezpacheco.catlike.framework.db

import com.fernandodominguezpacheco.catlike.framework.toBreed
import com.fernandodominguezpacheco.catlike.framework.toRoomBreed
import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.domain.Breed
import kotlinx.coroutines.Dispatchers
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

    override suspend fun getAllBreeds(): List<Breed> = withContext(Dispatchers.IO){
        breedDao.getAllBreeds().map{
            it.toBreed()
        }
    }
    override suspend fun getAllBreedWithLikes(): List<Breed> = withContext(Dispatchers.IO){
        breedDao.getAllBreedWithLikes().map{
            it.toBreed()
        }
    }

    override suspend fun getBreedById(id: String): Breed  = withContext(Dispatchers.IO){
        breedDao.getBreedById(id).toBreed()
    }

    override suspend fun isEmpty(): Boolean = withContext(Dispatchers.IO){ breedDao.breedCount() <= 0 }


    override suspend fun deleteAll() {
        breedDao.deleteAll()
    }


}