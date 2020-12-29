package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LikeDao {

    @Insert
    suspend fun addLike(like: Like)

    @Update
    suspend fun updateLike(like: Like)

    @Query("DELETE FROM [Like] WHERE breedId=:breedId")
    suspend fun deleteLike(breedId: String)

    @Query("SELECT * FROM [Like]")
    suspend fun getAllLikes() : List<Like>

    @Query("SELECT * FROM [Like] WHERE breedId =:id")
    suspend fun getLikeByBreed(id: String) : List<Like>

}