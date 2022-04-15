package com.example.moviemax.view.adapter.adapterdata

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemax.databinding.ViewholderVerticalBinding
import com.example.moviemax.utils.SPAN_COUNT_RECYCLER_TOP_RATING_MOVIES
import com.example.moviemax.view.adapter.adaptermovie.MovieListVerticalAdapter
import com.example.moviemax.view.adapter.base.BaseDataHolder
import com.example.moviemax.view.listview.Movie
import io.reactivex.Observable

class PopularMovieViewHolder(private val binding: ViewholderVerticalBinding) :
    BaseDataHolder<List<Movie>>(binding) {
    var paged  = 2
    var isLoading = false
    override fun bind(items:List<Movie>) = with(binding) {
       val  adapter = MovieListVerticalAdapter()
        rvPopularMovies.adapter = adapter
        rvPopularMovies.layoutManager = GridLayoutManager(context, SPAN_COUNT_RECYCLER_TOP_RATING_MOVIES)
       adapter.submitList(items)
      //  initScrollListener(items)
    }

//    private fun initScrollListener(items:List<Movie>) {
//        val recyclerView = binding.rvPopularMovies
//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
//                if (!isLoading) {
//                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == items.size - 1) {
//                        //bottom of list!
//                        loadMore()
//                        isLoading = true
//                    }
//                }
//            }
//        })
//    }
}