package com.fernandodominguezpacheco.catlike.framework.server

import com.fernandodominguezpacheco.catlike.framework.toBreed
import com.fernandodominguezpacheco.data.datasource.RemoteBreedDataSource
import com.fernandodominguezpacheco.domain.Breed

class BreedApiDataSource(
    private val apiService: BreedApiService
) : RemoteBreedDataSource {
    override suspend fun getAllBreeds(): List<Breed> {
        return apiService.getAllBreeds().map {
            it.toBreed()
        }
    }
}