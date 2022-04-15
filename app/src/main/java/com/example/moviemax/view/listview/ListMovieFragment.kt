package com.example.moviemax.view.listview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.moviemax.App
import com.example.moviemax.databinding.FragmentListMovieBinding
import com.example.moviemax.model.entity.DataModel
import com.example.moviemax.model.entity.Result
import com.example.moviemax.presenter.ListMoviePresenterImpl
import com.example.moviemax.utils.URL_ORIGINAL_IMAGE
import com.example.moviemax.utils.showImage
import com.example.moviemax.view.adapter.adapterdata.DataAdapter
import com.example.moviemax.view.adapter.adapterdata.Paging
import javax.inject.Inject

class ListMovieFragment : MvpAppCompatFragment(), ListView {
     var page = 1
    private val binding:FragmentListMovieBinding by viewBinding(CreateMethod.INFLATE)
  private  val dataAdapter = DataAdapter(object :DataAdapter.Retry{
        override fun tryAgain() {
            presenter.getPopularsAndTopRatingMovies(page)
        }
    },object : Paging{
      override fun getPage():List<Movie> {
          ++page
      val res =  presenter.getPaging(page)
         return res
      }
  })

    @Inject
    @InjectPresenter
    lateinit var presenter: ListMoviePresenterImpl

    @ProvidePresenter
    fun providePresenter(): ListMoviePresenterImpl = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (context?.applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        presenter.getPopularsAndTopRatingMovies(1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root
    override fun onDestroy() {
        super.onDestroy()
        presenter.clearDispose()
    }

    override fun setBaseRecyclerView(list: List<DataModel>) {
         with(binding){
             baseRecyclerView.layoutManager =LinearLayoutManager(requireContext(),  LinearLayoutManager.VERTICAL, false)
             baseRecyclerView.adapter = dataAdapter
             dataAdapter.addData(list)
             Log.d("setBaseRecyclerView","$list")
             baseRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                 override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                     Log.d("baseRecyclerView","$dx")
                     Log.d("baseRecyclerView","$dy")
                     super.onScrolled(recyclerView, dx, dy)
                 }
             })
         }
    }

    override fun addContentToToolbar(item: Result) {
                 binding.appbar.isVisible = true
           with(binding){
               showImage(requireContext(),URL_ORIGINAL_IMAGE + item.backdropPath,toolbarImage)
               movieName.text = item.name
           }
    }


}