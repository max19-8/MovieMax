package com.example.moviemax.view.adapter.adaptermovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.moviemax.databinding.MovieItemBinding
import com.example.moviemax.utils.URL_SMALL_IMAGE
import com.example.moviemax.utils.showImage
import com.example.moviemax.view.adapter.base.BaseMoviesHolder
import com.example.moviemax.view.listview.Movie

class MovieListVerticalAdapter : ListAdapter<Movie, BaseMoviesHolder>(BaseDiffCallbackItemMovie()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMoviesHolder {
        val inflater = LayoutInflater.from(parent.context)
                val binding = MovieItemBinding.inflate(inflater, parent, false)
          return MovieVerticalHolder(binding)
        }

    override fun onBindViewHolder(holder: BaseMoviesHolder, position: Int) {
        val current = currentList[position]
        holder.bind(current)
    }

    class MovieVerticalHolder(private val binding: MovieItemBinding) : BaseMoviesHolder(binding) {
        override fun bind(movie: Movie) {
            with(binding) {
                showImage(itemView.context,URL_SMALL_IMAGE + movie.posterPath,imageFilm )
                movieName.text = movie.name
                ratingInMovie.text = movie.voteAverage.toString()
            }
        }
    }

}
