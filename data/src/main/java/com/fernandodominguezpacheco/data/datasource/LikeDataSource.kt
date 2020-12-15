package com.fernandodominguezpacheco.data.datasource

import com.fernandodominguezpacheco.domain.Breed
import com.fernandodominguezpacheco.domain.Like

interface LikeDataSource {

    suspend fun addLike(like: Like)
    suspend fun updateLike(like: Like)
    suspend fun deleteLike(like: Like)
    suspend fun getAllLikes() : List<Like>
    suspend fun getLikeByBreed(breedId: String) : List<Like>

}