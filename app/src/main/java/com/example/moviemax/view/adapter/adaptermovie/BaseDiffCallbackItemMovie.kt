package com.example.moviemax.view.adapter.adaptermovie

import androidx.recyclerview.widget.DiffUtil
import com.example.moviemax.view.listview.Movie

class BaseDiffCallbackItemMovie:DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}