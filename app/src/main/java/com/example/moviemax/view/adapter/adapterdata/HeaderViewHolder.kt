package com.example.moviemax.view.adapter.adapterdata

import com.example.moviemax.databinding.HeaderBinding
import com.example.moviemax.view.adapter.base.BaseDataHolder

class HeaderViewHolder(private val binding: HeaderBinding): BaseDataHolder<String>(binding) {
    override fun bind(items: String) {
        binding.title.text = items
    }
}