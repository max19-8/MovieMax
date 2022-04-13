package com.example.moviemax.presenter

interface ListMoviePresenter {
    fun getPopularsAndTopRatingMovies(page:Int)
    fun clearDispose()
}