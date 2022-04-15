package com.example.moviemax.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.moviemax.R
import com.example.moviemax.model.entity.DataModel
import com.example.moviemax.model.entity.Model
import com.example.moviemax.model.entity.toMovie
import com.example.moviemax.model.repository.ListMoviesRepository
import com.example.moviemax.utils.ErrorType
import com.example.moviemax.view.listview.ListView
import com.example.moviemax.view.provider.ResourceProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

@InjectViewState
class ListMoviePresenterImpl(
    private val listMoviesRepository: ListMoviesRepository,
    private val resourceProvider: ResourceProvider
) : MvpPresenter<ListView>(), ListMoviePresenter {

    private var disposable: Disposable? = null

    override fun getPopularsAndTopRatingMovies(page:Int) {
        viewState.setBaseRecyclerView(listOf(DataModel.Shimmer))
        disposable = Observable.zip<Model, Model, Pair<Model, Model>>(
            listMoviesRepository.getTopRatingMovies(),
            listMoviesRepository.getPopularMovie(page)
        ) { top, popular -> Pair(top, popular) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { (topRating, mostPopular) -> Pair(topRating, mostPopular) }
            .subscribe({
                viewState.addContentToToolbar(it.second.results.first())
                viewState.setBaseRecyclerView(
                    listOf(
                        DataModel.HEADER((resourceProvider.getString(R.string.top_rating_text_view_text))),
                        DataModel.HorizontalItems(it.first.results.toMovie()),
                        DataModel.HEADER((resourceProvider.getString(R.string.popular_text_view_text))),
                        DataModel.VerticalItems((it.second.results.toMovie()))
                    )
                )
            }, { error ->
                val message = when (DataModel.Error(error.toString()).map(error)) {
                    ErrorType.NO_CONNECTION -> resourceProvider.getString(R.string.no_internet_connection_text)
                    ErrorType.SERVICE_UNAVAILABLE -> resourceProvider.getString(R.string.service_unavailable_message)
                    ErrorType.GENERIC_ERROR -> resourceProvider.getString(R.string.something_went_wrong)
                }
                viewState.setBaseRecyclerView(listOf(DataModel.Error(message)))
                Log.d("getTopRatingMovies", "$error")
            })
    }

    fun getPaging(page:Int){
        viewState.setBaseRecyclerView(listOf(DataModel.Shimmer))
        disposable = Observable.zip<Model, Model, Pair<Model, Model>>(
            listMoviesRepository.getTopRatingMovies(),
            listMoviesRepository.getPopularMovie(page)
        ) { top, popular -> Pair(top, popular) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { (topRating, mostPopular) -> Pair(topRating, mostPopular) }
            .subscribe({
                viewState.addContentToToolbar(it.second.results.first())
                viewState.setBaseRecyclerView(
                    listOf(
                        DataModel.HEADER((resourceProvider.getString(R.string.top_rating_text_view_text))),
                        DataModel.HorizontalItems(it.first.results.toMovie()),
                        DataModel.HEADER((resourceProvider.getString(R.string.popular_text_view_text))),
                        DataModel.VerticalItems(it.second.results.toMovie())
                    )
                )
            }, { error ->
                val message = when (DataModel.Error(error.toString()).map(error)) {
                    ErrorType.NO_CONNECTION -> resourceProvider.getString(R.string.no_internet_connection_text)
                    ErrorType.SERVICE_UNAVAILABLE -> resourceProvider.getString(R.string.service_unavailable_message)
                    ErrorType.GENERIC_ERROR -> resourceProvider.getString(R.string.something_went_wrong)
                }
                viewState.setBaseRecyclerView(listOf(DataModel.Error(message)))
                Log.d("getTopRatingMovies", "$error")
            })
    }

    override fun clearDispose() {
        disposable?.dispose()
    }
}