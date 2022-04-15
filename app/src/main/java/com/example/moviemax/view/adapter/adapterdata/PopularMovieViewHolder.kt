package com.example.moviemax.view.adapter.adapterdata

import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemax.databinding.ViewholderVerticalBinding
import com.example.moviemax.utils.SPAN_COUNT_RECYCLER_TOP_RATING_MOVIES
import com.example.moviemax.view.adapter.adaptermovie.MovieListVerticalAdapter
import com.example.moviemax.view.adapter.base.BaseDataHolder
import com.example.moviemax.view.listview.Movie

class PopularMovieViewHolder(private val binding: ViewholderVerticalBinding,private val paging: Paging) :
    BaseDataHolder<List<Movie>>(binding) {
    private var adapter = MovieListVerticalAdapter()
    override fun bind(items: List<Movie>) = with(binding) {
        rvPopularMovies.adapter = adapter
        var isLoading = false
       val manager =
            GridLayoutManager(itemView.context, SPAN_COUNT_RECYCLER_TOP_RATING_MOVIES)
        rvPopularMovies.layoutManager = manager
        adapter.submitList(items)
        rvPopularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                Log.d("ONSCROLLED","dx $dx")
                Log.d("ONSCROLLED"," dy $dy")
           //     if (dy > 0) {
//                    val position = manager.findLastVisibleItemPosition()
//                    val visibleItemCount = manager.childCount
//                    val pastVisibleItem = manager.findFirstCompletelyVisibleItemPosition()
//                    val totalItemCount = adapter.itemCount
//                    if (!isLoading){
//                        if (visibleItemCount + pastVisibleItem >= totalItemCount ) {
//                            isLoading = true
//                            val movies =  paging.getPage()
//                            adapter.addItems(items,movies)
//                            adapter.notifyDataSetChanged()
//                        }
//                    }
                }

        //    }
        })
    }
}

