package com.example.moviemax.view.adapter.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseDataHolder<T>(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    val context: Context = binding.root.context
    abstract fun bind(items:T)
}