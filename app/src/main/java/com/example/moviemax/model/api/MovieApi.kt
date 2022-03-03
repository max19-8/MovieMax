package com.example.moviemax.model.api

import com.example.moviemax.model.entity.Model
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieApi {
    @GET("/3/tv/popular?api_key=3cfd9e9aade3b868966f742eea2665c5")
    fun getPopularMovie():Observable<Model>

    @GET("/3/movie/top_rated?api_key=3cfd9e9aade3b868966f742eea2665c5")
    fun getTopRatingMovies():Observable<Model>
}