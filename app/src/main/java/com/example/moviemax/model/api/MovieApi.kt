package com.example.moviemax.model.api

import com.example.moviemax.model.entity.Model
import com.example.moviemax.utils.API_KEY
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/3/tv/popular?api_key=$API_KEY")
    fun getPopularMovie(@Query("page") page: Int): Observable<Model>

    @GET("/3/movie/top_rated?api_key=$API_KEY")
    fun getTopRatingMovies(): Observable<Model>
}