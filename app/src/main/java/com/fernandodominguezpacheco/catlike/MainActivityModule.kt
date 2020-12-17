package com.fernandodominguezpacheco.catlike

import com.fernandodominguezpacheco.data.repository.BreedRepository
import com.fernandodominguezpacheco.data.repository.LikeRepository
import com.fernandodominguezpacheco.usecases.GetAllBreeds
import com.fernandodominguezpacheco.usecases.GetAllLikes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainActivityModule {

    @Provides
    fun getAllBreeds(breedRepository: BreedRepository) = GetAllBreeds(breedRepository)

    @Provides
    fun getAllLikes(likeRepository: LikeRepository) = GetAllLikes(likeRepository)
}