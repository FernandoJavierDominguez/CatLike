package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Breed constructor(
    @PrimaryKey (autoGenerate = false)  val id: String,
    var name: String,
    var description: String,
    var origin: String,
    var temperament: String,
    var wikipedia_url: String,
    var url: String,
    /*@Embedded
    var likes: List<Like>*/
) {
}