package com.fernandodominguezpacheco.domain

data class Breed(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var origin: String = "",
    var temperament: String = "",
    var wikipedia_url: String = "",
    var url: String = "",
    var likes: List<Like> = emptyList()

) {

}