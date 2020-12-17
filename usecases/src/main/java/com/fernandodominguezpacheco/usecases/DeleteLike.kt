package com.fernandodominguezpacheco.usecases

import com.fernandodominguezpacheco.data.repository.LikeRepository
import com.fernandodominguezpacheco.domain.Like

class DeleteLike(private val likeRepository: LikeRepository) {

    suspend fun invoke(like: Like) = likeRepository.deleteLike(like)

}