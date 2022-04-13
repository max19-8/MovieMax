package com.example.moviemax.di

import android.content.Context
import com.example.moviemax.model.repository.ListMoviesRepository
import com.example.moviemax.presenter.ListMoviePresenterImpl
import com.example.moviemax.view.provider.ResourceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideMainPresenter(listMoviesRepository: ListMoviesRepository,resourceProvider: ResourceProvider)
            : ListMoviePresenterImpl =
        ListMoviePresenterImpl(listMoviesRepository,resourceProvider)
}