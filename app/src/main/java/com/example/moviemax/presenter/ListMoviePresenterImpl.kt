package com.example.moviemax.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.moviemax.model.repository.ListMoviesRepository
import com.example.moviemax.view.listview.ListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

@InjectViewState
class ListMoviePresenterImpl(private val listMoviesRepository: ListMoviesRepository) :
    MvpPresenter<ListView>(), ListMoviePresenter {
    var disposable: Disposable? = null

    override fun getPopularMovie() {
        disposable = listMoviesRepository.getPopularMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ listMovie ->
                viewState.showContent()
                viewState.showPopularMovies(listMovie)
            }, { error ->
                viewState.onDataErrorFromApi(error)
            }
            )
    }

    override fun getTopRatingMovie() {
        disposable = listMoviesRepository.getTopRatingMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ listMovie ->
                viewState.setContentFromToolbar(listMovie.results.first())
                viewState.showTopRatingMovies(listMovie)
            }, { error ->
                viewState.onDataErrorFromApi(error)
            }
            )
    }
}