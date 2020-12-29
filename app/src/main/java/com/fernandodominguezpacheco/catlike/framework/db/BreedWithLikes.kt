package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Embedded
import androidx.room.Relation

data class BreedWithLikes (
    @Embedded val breed: Breed,
    @Relation(parentColumn = "id", entityColumn = "breedId")
    val likes: List<Like>
)