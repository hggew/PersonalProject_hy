package com.example.exchangerate

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerate.network.ExchRate

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ExchRate>?){
    val adapter = recyclerView.adapter as ExchRateListAdapter
    adapter.submitList(data)
}

//
//@BindingAdapter("unittext")
//fun bindUnitText(textView: TextView, unitData: String?){
//    val tt = unitData.toString()
//    textView.text = tt
//}
