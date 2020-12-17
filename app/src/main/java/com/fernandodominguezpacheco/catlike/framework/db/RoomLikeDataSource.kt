package com.fernandodominguezpacheco.catlike.framework.db

import com.fernandodominguezpacheco.catlike.framework.toLike
import com.fernandodominguezpacheco.catlike.framework.toRoomLike
import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.domain.Like
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomLikeDataSource(db: BreedDb) : LikeDataSource {

    private val likeDao = db.likeDao()

    override suspend fun addLike(like: Like) {
        withContext(Dispatchers.IO){
            likeDao.addLike(like.toRoomLike())
        }
    }

    override suspend fun updateLike(like: Like) {
        withContext(Dispatchers.IO){
            likeDao.updateLike(like.toRoomLike())
        }
    }

    override suspend fun deleteLike(like: Like) {
        withContext(Dispatchers.IO){
            likeDao.deleteLike(like.breedId)
        }
    }

    override suspend fun getAllLikes(): List<Like> = withContext(Dispatchers.IO){
        likeDao.getAllLikes().map {
            it.toLike()
        }
    }

    override suspend fun getLikeByBreed(breedId: String): List<Like>  = withContext(Dispatchers.IO){
        likeDao.getLikeByBreed(breedId).map{
            it.toLike()
        }
    }

}