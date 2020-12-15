package com.fernandodominguezpacheco.data.datasource

import com.fernandodominguezpacheco.domain.Breed

interface RemoteBreedDataSource {

    suspend fun getAllBreeds(): List<Breed>

}