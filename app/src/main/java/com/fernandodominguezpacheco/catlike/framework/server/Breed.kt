package com.fernandodominguezpacheco.catlike.framework.server

import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("origin") val origin: String?,
    @SerializedName("temperament") val temperament: String?,
    @SerializedName("wikipedia_url") val wikipedia_url: String?,
    @SerializedName("image") val image: Image?
)