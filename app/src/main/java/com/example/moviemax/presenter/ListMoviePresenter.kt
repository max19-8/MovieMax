package com.example.moviemax.presenter

import com.example.moviemax.view.listview.Movie

interface ListMoviePresenter {
    fun getPopularsAndTopRatingMovies(page:Int)
    fun clearDispose()
}