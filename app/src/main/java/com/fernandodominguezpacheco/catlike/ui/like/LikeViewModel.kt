package com.fernandodominguezpacheco.catlike.ui.like

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fernandodominguezpacheco.data.repository.LikeRepository

class LikeViewModel @ViewModelInject constructor(
    private val likeRepository: LikeRepository
): ViewModel() {



    val likeItems = likeRepository.getAllLikes().asLiveData()

}