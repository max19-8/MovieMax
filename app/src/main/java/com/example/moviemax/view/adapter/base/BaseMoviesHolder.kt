package com.example.moviemax.view.adapter.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.moviemax.view.listview.Movie

abstract class BaseMoviesHolder(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(movie:Movie)
}