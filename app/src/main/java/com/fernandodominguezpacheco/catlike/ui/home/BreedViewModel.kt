package com.fernandodominguezpacheco.catlike.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.catlike.utils.NetworkUtils
import com.fernandodominguezpacheco.domain.Breed
import com.fernandodominguezpacheco.usecases.GetAllBreeds
import com.fernandodominguezpacheco.usecases.GetAllBreedsRoom
import kotlinx.coroutines.launch

class BreedViewModel @ViewModelInject constructor(
    private val getAllBreeds: GetAllBreeds,
    private val getAllBreedsRoom: GetAllBreedsRoom,
    private val networkUtils: NetworkUtils
) : ViewModel() {


    private val _breedItems = MutableLiveData<List<Breed>>()
    val breedItems: LiveData<List<Breed>> get() = _breedItems

    init{
        getBreeds()
    }

    fun getBreeds() {
        viewModelScope.launch {
            if(networkUtils.isInternetAvailable()){
                _breedItems.value = getAllBreeds.invoke()
            }
            else{
                _breedItems.value = getAllBreedsRoom.invoke()
            }
        }
    }



}