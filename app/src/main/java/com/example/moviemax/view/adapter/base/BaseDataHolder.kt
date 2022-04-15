package com.example.moviemax.view.adapter.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseDataHolder<T>(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(items:T)
}