package com.fernandodominguezpacheco.catlike.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.domain.Like
import com.fernandodominguezpacheco.usecases.AddLike
import com.fernandodominguezpacheco.usecases.DeleteLike
import kotlinx.coroutines.launch
import java.util.*

class BreedDetailViewModel @ViewModelInject constructor(
    private val addLike: AddLike,
    private val deleteLike: DeleteLike
) : ViewModel() {

    private val _like = MutableLiveData<Boolean>()
    val like: LiveData<Boolean> get() = _like


    fun addLike(breedId: String){
        val like = Like(0, breedId, Date())
        viewModelScope.launch {
            addLike.invoke(like)
        }
    }
    fun deleteLike(breedId: String){
        val like = Like(0, breedId, Date())
        viewModelScope.launch {
            deleteLike.invoke(like)
        }
    }
}
