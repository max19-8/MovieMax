package com.example.moviemax.di

import com.example.moviemax.view.listview.ListMovieFragment
import com.example.moviemax.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, PresenterModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(listMovieFragment: ListMovieFragment)
}