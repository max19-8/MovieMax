package com.example.moviemax.di

import com.example.moviemax.model.repository.ListMoviesRepository
import com.example.moviemax.presenter.ListMoviePresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideMainPresenter(listMoviesRepository: ListMoviesRepository)
            : ListMoviePresenterImpl =
        ListMoviePresenterImpl(listMoviesRepository)
}