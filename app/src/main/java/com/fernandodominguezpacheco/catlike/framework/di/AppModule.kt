package com.fernandodominguezpacheco.catlike.framework.di

import android.app.Application
import androidx.room.Room
import com.fernandodominguezpacheco.catlike.BuildConfig
import com.fernandodominguezpacheco.catlike.framework.db.BreedDb
import com.fernandodominguezpacheco.catlike.framework.db.RoomBreedDataSource
import com.fernandodominguezpacheco.catlike.framework.db.RoomLikeDataSource
import com.fernandodominguezpacheco.catlike.framework.server.BreedApiDataSource
import com.fernandodominguezpacheco.catlike.framework.server.BreedApiService
import com.fernandodominguezpacheco.catlike.utils.Constants
import com.fernandodominguezpacheco.data.datasource.LikeDataSource
import com.fernandodominguezpacheco.data.datasource.LocalBreedDataSource
import com.fernandodominguezpacheco.data.datasource.RemoteBreedDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    //LOCAL DATA SOURCE
    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        BreedDb::class.java,
        "breed-db"
    ).build()

    @Provides
    fun localStoryDataSourceProvider(db: BreedDb) : LocalBreedDataSource = RoomBreedDataSource(db)

    @Provides
    fun likeDataSourceProvider(db: BreedDb) : LikeDataSource = RoomLikeDataSource(db)

    //SERVER DATA SOURCE
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL


    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): BreedApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
        .run{ create(BreedApiService::class.java) }

    @Provides
    fun remoteBreedDataSourceProvider(apiService: BreedApiService) : RemoteBreedDataSource =  BreedApiDataSource(apiService)


}