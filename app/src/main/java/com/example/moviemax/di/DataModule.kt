package com.example.moviemax.di

import com.example.moviemax.model.api.MovieApi
import com.example.moviemax.model.repository.ListMoviesRepository
import com.example.moviemax.model.repository.ListMoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideListMovieRepository(movieApi: MovieApi): ListMoviesRepository =
        ListMoviesRepositoryImpl(movieApi)
}