package com.example.moviemax.model.entity

import com.example.moviemax.utils.ErrorType
import com.example.moviemax.view.listview.Movie
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class DataModel {
    data class VerticalItems( val list: List<Movie>):DataModel()
    data class HorizontalItems(  val list: List<Movie>):DataModel()
    data class HEADER(val title:String) : DataModel()
    data class Error(val message:String):DataModel(){
        fun map(e:Throwable) = when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        }
    }
    object Shimmer : DataModel()
}









