package com.fernandodominguezpacheco.catlike.ui.like

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.domain.Breed
import com.fernandodominguezpacheco.domain.Like
import com.fernandodominguezpacheco.usecases.GetAllLikes
import kotlinx.coroutines.launch

class LikeViewModel @ViewModelInject constructor(
    private val getAllLikes: GetAllLikes
): ViewModel() {

    private val _likeItems = MutableLiveData<List<Like>>()
    val likeItems: LiveData<List<Like>> get() = _likeItems

    init{
        getLikes()
    }

    fun getLikes() {
        viewModelScope.launch {
            _likeItems.value = getAllLikes.invoke()
        }
    }
}