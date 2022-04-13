package com.example.moviemax.view.adapter.adapterdata

import com.example.moviemax.databinding.NoConnectionLayoutBinding
import com.example.moviemax.view.adapter.base.BaseDataHolder

class ErrorViewHolder(private val binding:NoConnectionLayoutBinding,private val retry: DataAdapter.Retry): BaseDataHolder<String>(binding) {
    override fun bind(items: String) {
        binding.messageTextview.text = items
        binding.tryAgainBtn.setOnClickListener {
            retry.tryAgain()
        }
    }



}

