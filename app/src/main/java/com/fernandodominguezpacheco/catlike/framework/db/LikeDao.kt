package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LikeDao {

    @Insert
    suspend fun addLike(like: Like)

    @Update
    suspend fun updateLike(like: Like)

    @Query("DELETE FROM 'Like' WHERE breedId=:breedId")
    suspend fun deleteLike(breedId: String)

    @Query("SELECT * FROM 'Like'")
    fun getAllLikes() : Flow<List<Like>>

    @Query("SELECT * FROM 'Like' WHERE breedId =:id")
    fun getLikeByBreed(id: String) : Flow<List<Like>>

}