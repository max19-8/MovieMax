package com.example.moviemax.view.adapter.adapterdata

import com.example.moviemax.view.listview.Movie

interface Paging {
    fun getPage():List<Movie>
}
