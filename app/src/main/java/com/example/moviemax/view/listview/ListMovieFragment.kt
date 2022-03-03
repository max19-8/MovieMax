package com.example.moviemax.view.listview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.moviemax.App
import com.example.moviemax.R
import com.example.moviemax.databinding.FragmentListMovieBinding
import com.example.moviemax.model.entity.Model
import com.example.moviemax.model.entity.Result
import com.example.moviemax.presenter.ListMoviePresenterImpl
import com.example.moviemax.view.adapter.MovieAdapter
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class ListMovieFragment : MvpAppCompatFragment(), ListView {

    private var _binding: FragmentListMovieBinding? = null
    private val binding get() = _binding!!

    @Inject
    @InjectPresenter
    lateinit var presenter: ListMoviePresenterImpl

    @ProvidePresenter
    fun providePresenter(): ListMoviePresenterImpl = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (context?.applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        presenter.getPopularMovie()
        presenter.getTopRatingMovie()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListMovieBinding.bind(
            inflater.inflate(
                R.layout.fragment_list_movie,
                container,
                false
            )
        )
        return binding.root
    }

    override fun showPopularMovies(items: Model) {
        val popularMoviesAdapter = MovieAdapter()
        val recyclerPopularMovies = binding.recyclerPopularMovies
        recyclerPopularMovies.adapter = popularMoviesAdapter
        popularMoviesAdapter.submitList(items.results)
    }

    override fun showTopRatingMovies(items: Model) {
        val topRatingMoviesAdapter = MovieAdapter()
        val recyclerViewTopRatingMovies = binding.recyclerTopRatingMovies
        recyclerViewTopRatingMovies.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerViewTopRatingMovies.adapter = topRatingMoviesAdapter
        topRatingMoviesAdapter.submitList(items.results)
    }

    override fun setContentFromToolbar(item: Result) {
        Glide.with(requireContext())
            .load("https://image.tmdb.org/t/p/original" + item.backdrop_path)
            .into(binding.toolbarImage)
        binding.nameMovie.text = item.title
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        with(binding) {
            popularMoviesTextView.isVisible = false
            topRatingMoviesTextView.isVisible = false
            collapsingToolbar.isVisible = false
            appbar.isVisible = false
            refreshButton.isVisible = true
            noInternetTextView.isVisible = true
            recyclerPopularMovies.isVisible = false
            recyclerTopRatingMovies.isVisible = false
            toolbarImage.isVisible = false
            nameMovie.isVisible = false
            Snackbar.make(binding.root, "check your network connection", Snackbar.LENGTH_LONG)
                .show()
            refreshButton.setOnClickListener {
                presenter.getPopularMovie()
                presenter.getTopRatingMovie()
            }
        }
    }

    override fun showContent() {
        with(binding) {
            popularMoviesTextView.isVisible = true
            topRatingMoviesTextView.isVisible = true
            collapsingToolbar.isVisible = true
            appbar.isVisible = true
            recyclerPopularMovies.isVisible = true
            recyclerTopRatingMovies.isVisible = true
            toolbarImage.isVisible = true
            refreshButton.isVisible = false
            noInternetTextView.isVisible = false
            appbar.isVisible = true
            nameMovie.isVisible = true
        }
    }
}