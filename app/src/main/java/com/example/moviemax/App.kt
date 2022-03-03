package com.example.moviemax

import android.app.Application
import com.example.moviemax.di.AppComponent
import com.example.moviemax.di.AppModule
import com.example.moviemax.di.DaggerAppComponent

class App:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(context = this))
            .build()
    }
}