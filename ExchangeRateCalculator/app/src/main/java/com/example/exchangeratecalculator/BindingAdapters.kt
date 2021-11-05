package com.example.exchangeratecalculator

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangeratecalculator.network.ExchangeRate


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ExchangeRate>?){
    val adapter = recyclerView.adapter as ExchRateListAdapter
    adapter.submitList(data)
}

@BindingAdapter("unittext")
fun bindUnitData(textView: TextView, text:ExchangeRate){
    textView.text = text.value
}

//            android:unittext="@{ExchRate.unit}"
//            android:valuetext="@{ExchRate.value}"