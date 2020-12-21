package com.fernandodominguezpacheco.data.repository

import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.domain.Breed
import com.fernandodominguezpacheco.domain.Like
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class LikeRepository(private val likeDataSource: LikeDataSource) {

    suspend fun addLike(like: Like) = likeDataSource.addLike(like)
    suspend fun updateLike(like: Like) = likeDataSource.updateLike(like)
    suspend fun deleteLike(like: Like) = likeDataSource.deleteLike(like)
    fun getAllLikes() : Flow<List<Like>> = flow { likeDataSource.getAllLikes() }
    suspend fun getLikeByBreed(breedId: String) : List<Like> = likeDataSource.getLikeByBreed(breedId)

}