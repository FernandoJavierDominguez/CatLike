package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Breed::class, Like::class],
    version = 1
)

abstract class BreedDb : RoomDatabase() {

    abstract fun breedDao(): BreedDao

    abstract fun likeDao(): LikeDao

}