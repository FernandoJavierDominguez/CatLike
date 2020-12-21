package com.fernandodominguezpacheco.catlike.ui.like

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.fernandodominguezpacheco.data.repository.LikeRepository
import com.fernandodominguezpacheco.domain.Like
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LikeViewModel @ViewModelInject constructor(
    private val likeRepository: LikeRepository
): ViewModel() {

    private val _likeItems = MutableLiveData<List<Like>>()
    val likeItems: LiveData<List<Like>> get() = _likeItems

    init {
        viewModelScope.launch {
            likeRepository.getAllLikes().collect {
                _likeItems.value = it
            }
        }

    }



}