package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


interface LikeDao {

    @Insert
    suspend fun addLike(like: Like)

    @Update
    suspend fun updateLike(like: Like)

    @Delete
    suspend fun deleteLike(like: Like)

    @Query("SELECT * FROM Like")
    suspend fun getAllLikes() : List<Like>

    @Query("SELECT * FROM Like WHERE breedId =:id")
    suspend fun getLikeByBreed(id: String) : List<Like>

}