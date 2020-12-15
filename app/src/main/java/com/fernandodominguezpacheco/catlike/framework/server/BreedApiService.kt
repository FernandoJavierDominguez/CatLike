package com.fernandodominguezpacheco.catlike.framework.server

import retrofit2.http.GET

interface BreedApiService {

    @GET("https://api.thecatapi.com/v1/breeds")
    suspend fun getAllBreeds() : List<Breed>
}