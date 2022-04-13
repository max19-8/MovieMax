package com.example.moviemax.model.entity

import com.example.moviemax.view.listview.Movie
import com.google.gson.annotations.SerializedName

  data  class Result(
          @SerializedName("backdrop_path")
          val backdropPath: String,
          @SerializedName("first_air_date")
          val firstAirDate: String,
          @SerializedName("genre_ids")
          val genreIds: List<Int>,
          @SerializedName("id")
          val id: Int,
          @SerializedName("title")
          val title: String,
          @SerializedName("name")
          val name:String,
          @SerializedName("origin_country")
          val originCountry: List<String>,
          @SerializedName("original_language")
          val originalLanguage: String,
          @SerializedName("original_name")
          val originalName: String,
          @SerializedName("overview")
          val overview: String,
          @SerializedName("popularity")
          val popularity: Double,
          @SerializedName("poster_path")
          val posterPath: String,
          @SerializedName("vote_average")
          val voteAverage: Double,
          @SerializedName("vote_count")
          val voteCount: Int)

fun List<Result>.toMovie() = map {
    Movie(
        backdropPath = it.backdropPath,
        firstAirDate = it.firstAirDate,
        genreIds = it.genreIds,
        id = it.id,
        title = it.title,
        name = it.name,
        originCountry = it.originCountry,
        originalLanguage = it.originalLanguage,
        originalName = it.originalName,
        overview = it.overview,
        popularity = it.popularity,
        posterPath = it.posterPath,
        voteAverage = it.voteAverage,
        voteCount = it.voteCount
    )
}