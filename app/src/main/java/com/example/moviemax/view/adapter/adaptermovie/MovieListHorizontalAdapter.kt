package com.example.moviemax.view.adapter.adaptermovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.moviemax.databinding.MovieHorizontalItemBinding
import com.example.moviemax.utils.URL_ORIGINAL_IMAGE
import com.example.moviemax.utils.showImage
import com.example.moviemax.view.adapter.base.BaseMoviesHolder
import com.example.moviemax.view.listview.Movie

class MovieListHorizontalAdapter : ListAdapter<Movie, BaseMoviesHolder>(BaseDiffCallbackItemMovie()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMoviesHolder {
        val inflater = LayoutInflater.from(parent.context)
       val  binding = MovieHorizontalItemBinding.inflate(inflater, parent, false)
        return MovieHorizontalHolder(binding)
    }

    override fun getItemCount(): Int  = Int.MAX_VALUE

    override fun onBindViewHolder(holder: BaseMoviesHolder, position: Int) {
        val pos = position % currentList.size
        holder.bind(currentList[pos])
    }

    class MovieHorizontalHolder(private val binding: MovieHorizontalItemBinding): BaseMoviesHolder(binding) {
        override fun bind(movie: Movie) {
            with(binding) {
                showImage(itemView.context, URL_ORIGINAL_IMAGE + movie.backdropPath,imageMovie)
                movieTitle.text = movie.title
                ratingInMovie.text = movie.voteAverage.toString()
            }
        }
    }
}