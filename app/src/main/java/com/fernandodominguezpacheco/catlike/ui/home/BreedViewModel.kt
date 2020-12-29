package com.fernandodominguezpacheco.catlike.ui.home


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.fernandodominguezpacheco.catlike.utils.NetworkUtils
import com.fernandodominguezpacheco.data.repository.BreedRepository
import kotlinx.coroutines.launch

class BreedViewModel @ViewModelInject constructor(
    private val networkUtils: NetworkUtils,
    private val breedRepository: BreedRepository
) : ViewModel() {

    val breedItems = breedRepository.getAllBreeds().asLiveData()

    init{
        viewModelScope.launch {
            breedRepository.addCacheBreed()
        }
    }
}