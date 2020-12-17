package com.fernandodominguezpacheco.usecases

import com.fernandodominguezpacheco.data.repository.BreedRepository
import com.fernandodominguezpacheco.domain.Breed

class GetAllBreeds(private val breedRepository: BreedRepository) {

    suspend fun invoke() : List<Breed> = breedRepository.getAllBreeds()

    //suspend fun invoke() : List<Breed> = emptyList()
}