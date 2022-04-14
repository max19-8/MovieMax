package com.example.moviemax.view.adapter.adapterdata

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemax.databinding.ViewholderHorizontalBinding
import com.example.moviemax.view.adapter.adaptermovie.MovieListHorizontalAdapter
import com.example.moviemax.view.adapter.base.BaseDataHolder
import com.example.moviemax.view.listview.Movie

class TopRatingMovieViewHolder(private val binding: ViewholderHorizontalBinding) :
    BaseDataHolder<List<Movie>>(binding) {
    override fun bind(items: List<Movie>) = with(binding) {
        val  adapter = MovieListHorizontalAdapter()
        rvTopRatingMovie.adapter = adapter
        rvTopRatingMovie.scrollToPosition(Int.MAX_VALUE/2)
        rvTopRatingMovie.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(items)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rvTopRatingMovie)
        rvTopRatingMovie.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                Log.d("ONSCROLLE","$dx")
                Log.d("ONSCROLLE","$dy")
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}