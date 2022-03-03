package com.example.moviemax.model.repository

import com.example.moviemax.model.entity.Model
import io.reactivex.Observable

interface ListMoviesRepository {
    fun getPopularMovie(): Observable<Model>
    fun getTopRatingMovies():Observable<Model>
}