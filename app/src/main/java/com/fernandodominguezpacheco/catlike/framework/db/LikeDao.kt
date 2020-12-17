package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.*

@Dao
interface LikeDao {

    @Insert
    suspend fun addLike(like: Like)

    @Update
    suspend fun updateLike(like: Like)

    @Delete
    suspend fun deleteLike(like: Like)

    @Query("SELECT * FROM [Like]")
    suspend fun getAllLikes() : List<Like>

    @Query("SELECT * FROM [Like] WHERE breedId =:id")
    suspend fun getLikeByBreed(id: String) : List<Like>

}