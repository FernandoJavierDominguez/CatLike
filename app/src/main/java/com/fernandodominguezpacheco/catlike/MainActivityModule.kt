package com.fernandodominguezpacheco.catlike

import com.fernandodominguezpacheco.data.repository.BreedRepository
import com.fernandodominguezpacheco.data.repository.LikeRepository
import com.fernandodominguezpacheco.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainActivityModule {

    @Provides
    fun getAllBreeds(breedRepository: BreedRepository) = GetAllBreeds(breedRepository)

    @Provides
    fun getAllBreedsRoom(breedRepository: BreedRepository) = GetAllBreedsRoom(breedRepository)

    /*@Provides
    fun getAllLikes(likeRepository: LikeRepository) = GetAllLikes(likeRepository)*/

    @Provides
    fun addLike(likeRepository: LikeRepository) = AddLike(likeRepository)

    @Provides
    fun deleteLike(likeRepository: LikeRepository) = DeleteLike(likeRepository)
}