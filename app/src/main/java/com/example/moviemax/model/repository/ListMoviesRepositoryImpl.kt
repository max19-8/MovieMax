package com.example.moviemax.model.repository

import com.example.moviemax.model.api.MovieApi

class ListMoviesRepositoryImpl(private val movieApi: MovieApi) : ListMoviesRepository {
    override fun getPopularMovie(page:Int) = movieApi.getPopularMovie(page)
    override fun getTopRatingMovies() = movieApi.getTopRatingMovies()
}