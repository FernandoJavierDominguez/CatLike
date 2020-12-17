package com.fernandodominguezpacheco.catlike

import android.app.Application
/*import com.fernandodominguezpacheco.catlike.framework.di.AppModule
import com.fernandodominguezpacheco.catlike.framework.di.BreedComponent
import com.fernandodominguezpacheco.catlike.framework.di.DataModule*/
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BreedApp: Application() {
   /* private lateinit var component: BreedComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerBreedComponent.builder()
            .mainActivityModule(MainActivityModule())
            .appModule(AppModule())
            .dataModule(DataModule())
            .build()
    }
    fun getComponent() = component*/
}