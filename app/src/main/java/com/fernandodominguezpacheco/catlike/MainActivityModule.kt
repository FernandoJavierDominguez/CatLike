package com.fernandodominguezpacheco.catlike

import com.fernandodominguezpacheco.data.repository.LikeRepository
import com.fernandodominguezpacheco.usecases.AddLike
import com.fernandodominguezpacheco.usecases.DeleteLike
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainActivityModule {


    /*@Provides
    fun getAllLikes(likeRepository: LikeRepository) = GetAllLikes(likeRepository)*/

    @Provides
    fun addLike(likeRepository: LikeRepository) = AddLike(likeRepository)

    @Provides
    fun deleteLike(likeRepository: LikeRepository) = DeleteLike(likeRepository)
}