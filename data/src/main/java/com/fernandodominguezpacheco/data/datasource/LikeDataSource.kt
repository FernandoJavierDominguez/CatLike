package com.fernandodominguezpacheco.data.datasource

import com.fernandodominguezpacheco.domain.Like
import kotlinx.coroutines.flow.Flow

interface LikeDataSource {

    suspend fun addLike(like: Like)
    suspend fun updateLike(like: Like)
    suspend fun deleteLike(like: Like)
    fun getAllLikes() : Flow<List<Like>>
    fun getLikeByBreed(breedId: String) : Flow<List<Like>>
}