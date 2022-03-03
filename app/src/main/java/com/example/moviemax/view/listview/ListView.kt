package com.example.moviemax.view.listview

import com.arellomobile.mvp.MvpView
import com.example.moviemax.model.entity.Model
import com.example.moviemax.model.entity.Result

interface ListView:MvpView {
    fun showPopularMovies(items: Model)
    fun onDataErrorFromApi(throwable: Throwable)
    fun showTopRatingMovies(items: Model)
    fun setContentFromToolbar(item: Result)
    fun showContent()
}