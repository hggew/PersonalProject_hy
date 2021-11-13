package com.example.exchangerate

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerate.network.ExchRate

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ExchRate>?){
    val adapter = recyclerView.adapter as ExchRateListAdapter
    adapter.submitList(data)
}

