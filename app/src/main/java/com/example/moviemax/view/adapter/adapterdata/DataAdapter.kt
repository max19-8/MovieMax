package com.example.moviemax.view.adapter.adapterdata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemax.databinding.*
import com.example.moviemax.model.entity.DataModel
import com.example.moviemax.model.entity.MovieTypes
import com.example.moviemax.view.adapter.base.BaseDataHolder
import java.util.logging.Handler

class DataAdapter(private val retry: Retry,private val paging: Paging) : RecyclerView.Adapter<BaseDataHolder<*>>() {

  private  var listResult: List<DataModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseDataHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
      return  when(viewType){
            MovieTypes.TYPE_POPULAR_MOVIES.ordinal -> {
             val  binding = ViewholderVerticalBinding.inflate(inflater, parent, false)
                PopularMovieViewHolder(binding,paging)
            }
          MovieTypes.TYPE_TOP_RATING_MOVIES.ordinal-> {
                val binding = ViewholderHorizontalBinding.inflate(inflater, parent, false)
               TopRatingMovieViewHolder(binding)
            }

          MovieTypes.TYPE_HEADER.ordinal -> {
              val binding = HeaderBinding.inflate(inflater, parent, false)
              HeaderViewHolder(binding)
          }

          MovieTypes.TYPE_ERROR.ordinal -> {
              val binding = NoConnectionLayoutBinding.inflate(inflater,parent,false)
              ErrorViewHolder(binding,retry)
          }

          MovieTypes.TYPE_SHIMMER.ordinal -> {
              val binding = ShimmerPlaceholderLayoutBinding.inflate(inflater,parent,false)
              ShimmerViewHolder(binding)
          }
          else ->  throw IllegalArgumentException("The viewType value of  is not supported")
      }
    }
    override fun onBindViewHolder(holder: BaseDataHolder<*>, position: Int) {
        val item = listResult[position]
        when(holder){
            is TopRatingMovieViewHolder -> {
                holder.bind((item as DataModel.HorizontalItems).list)
            }
            is PopularMovieViewHolder -> {
                holder.bind((item as DataModel.VerticalItems).list)
            }
             is HeaderViewHolder -> {
                holder.bind((item as DataModel.HEADER).title)
            }
            is ErrorViewHolder -> {
                holder.bind((item as DataModel.Error).message)
            }
            is ShimmerViewHolder -> {
                holder.bind((item as DataModel.Shimmer).toString())
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(listResult[position]){
            is DataModel.HorizontalItems -> MovieTypes.TYPE_TOP_RATING_MOVIES.ordinal
            is DataModel.VerticalItems -> MovieTypes.TYPE_POPULAR_MOVIES.ordinal
            is DataModel.HEADER -> MovieTypes.TYPE_HEADER.ordinal
            is DataModel.Error -> MovieTypes.TYPE_ERROR.ordinal
            is DataModel.Shimmer -> MovieTypes.TYPE_SHIMMER.ordinal
        }
    }
    override fun getItemCount(): Int = listResult.size

    fun addData(list: List<DataModel>) {
        listResult = list
        notifyDataSetChanged()
    }

    interface Retry {
        fun tryAgain()
    }
 }