package com.fernandodominguezpacheco.catlike.framework

import com.fernandodominguezpacheco.domain.Breed
import com.fernandodominguezpacheco.domain.Like
import com.fernandodominguezpacheco.catlike.framework.db.Breed as RoomBreed
import com.fernandodominguezpacheco.catlike.framework.db.BreedWithLikes as RoomBreedWithLikes
import com.fernandodominguezpacheco.catlike.framework.db.Like as RoomLike
import com.fernandodominguezpacheco.catlike.framework.server.Breed as ServerBreed


//Breed
fun Breed.toRoomBreed() : RoomBreed = RoomBreed(
    id,
    name,
    description,
    origin,
    temperament,
    wikipedia_url,
    url
)

fun RoomBreed.toBreed() : Breed = Breed(
    id,
    name,
    description,
    origin,
    temperament,
    wikipedia_url,
    url,
)

fun RoomBreedWithLikes.toBreed() : Breed = Breed(
    breed.id,
    breed.name,
    breed.description,
    breed.origin,
    breed.temperament,
    breed.wikipedia_url,
    breed.url,
    likes.map { it.toLike() }
)


fun ServerBreed.toBreed() : Breed = Breed(
        id,
        name?: "",
        description ?: "",
        origin ?: "",
        temperament ?: "",
        wikipedia_url ?: "",
        image?.url ?: "",
)


//Like
fun Like.toRoomLike() : RoomLike = RoomLike(
    id,
    breedId,
    date
)

fun RoomLike.toLike() : Like = Like(
    id,
    breedId,
    date
)
