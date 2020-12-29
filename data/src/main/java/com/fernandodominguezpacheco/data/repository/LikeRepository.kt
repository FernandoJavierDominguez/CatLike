package com.fernandodominguezpacheco.data.repository

import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.domain.Like
import kotlinx.coroutines.flow.Flow


class LikeRepository(private val likeDataSource: LikeDataSource) {

    suspend fun addLike(like: Like) = likeDataSource.addLike(like)
    suspend fun updateLike(like: Like) = likeDataSource.updateLike(like)
    suspend fun deleteLike(like: Like) = likeDataSource.deleteLike(like)
    fun getAllLikes() : Flow<List<Like>> = likeDataSource.getAllLikes()
    fun getLikeByBreed(breedId: String) : Flow<List<Like>> = likeDataSource.getLikeByBreed(breedId)

}