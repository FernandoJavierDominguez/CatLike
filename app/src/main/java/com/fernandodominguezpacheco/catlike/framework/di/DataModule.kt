package com.fernandodominguezpacheco.catlike.framework.di

import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.data.datasource.RemoteBreedDataSource
import com.fernandodominguezpacheco.data.repository.BreedRepository
import com.fernandodominguezpacheco.data.repository.LikeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun breedRepositoryProvider(localBreedDataSource: LocalBreedDataSource, remoteBreedDataSource: RemoteBreedDataSource, likeDataSource: LikeDataSource) = BreedRepository(localBreedDataSource,remoteBreedDataSource, likeDataSource)

    @Provides
    fun likeRepositoryProvider(likeDataSource: LikeDataSource) = LikeRepository(likeDataSource)
}