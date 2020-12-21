package com.fernandodominguezpacheco.usecases

import com.fernandodominguezpacheco.data.repository.BreedRepository
import com.fernandodominguezpacheco.domain.Breed

class GetAllBreedsRoom(private val breedRepository: BreedRepository) {

    suspend fun invoke() : List<Breed> = breedRepository.getAllBreedsRoom()

}