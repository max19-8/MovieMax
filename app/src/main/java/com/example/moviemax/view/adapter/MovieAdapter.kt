package com.example.moviemax.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviemax.databinding.MovieItemBinding
import com.example.moviemax.model.entity.Result

class MovieAdapter: ListAdapter<Result, MovieAdapter.ViewPagerHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewPagerHolder(
            binding = MovieItemBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val currentDay = currentList[position]
        holder.bind(currentDay)
    }

     class ViewPagerHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Result) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185" + movie.poster_path)
                    .into(imageFilm)
                nameMovie.text = movie.title
                ratingInMovie.text = movie.vote_average.toString()
            }
        }
    }
}