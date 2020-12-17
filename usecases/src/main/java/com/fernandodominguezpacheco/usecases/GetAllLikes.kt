package com.fernandodominguezpacheco.usecases

import com.fernandodominguezpacheco.data.repository.LikeRepository
import com.fernandodominguezpacheco.domain.Like

class GetAllLikes(private val likeRepository: LikeRepository) {

    suspend fun invoke() : List<Like> = likeRepository.getAllLikes()
}