package com.fernandodominguezpacheco.catlike.framework.db

import com.fernandodominguezpacheco.catlike.framework.toLike
import com.fernandodominguezpacheco.catlike.framework.toRoomLike
import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.domain.Like
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    override fun getAllLikes(): Flow<List<Like>> = likeDao.getAllLikes().map {
        likes -> likes.map { it.toLike() }
    }

    override fun getLikeByBreed(breedId: String): Flow<List<Like>> =  likeDao.getLikeByBreed(breedId).map{
        lists -> lists.map { it.toLike() }
    }

}