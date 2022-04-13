package com.example.moviemax.view.listview

import com.arellomobile.mvp.MvpView
import com.example.moviemax.model.entity.DataModel
import com.example.moviemax.model.entity.Model
import com.example.moviemax.model.entity.Result
import java.util.*

interface ListView : MvpView {
    fun addContentToToolbar(item: Result)
    fun setBaseRecyclerView(list: List<DataModel>)
}