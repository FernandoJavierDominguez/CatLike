package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Breed::class, Like::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class BreedDb : RoomDatabase() {

    abstract fun breedDao(): BreedDao

    abstract fun likeDao(): LikeDao

}