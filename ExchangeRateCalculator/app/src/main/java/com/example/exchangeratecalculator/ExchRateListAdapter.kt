package com.example.exchangeratecalculator

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangeratecalculator.databinding.ExchRateListItemBinding
import com.example.exchangeratecalculator.network.ExchangeRate

class ExchRateListAdapter :
    ListAdapter<ExchangeRate, ExchRateListAdapter.ExchRateViewHolder>(DiffCallback) {


    class ExchRateViewHolder(private var binding: ExchRateListItemBinding)
        :RecyclerView.ViewHolder(binding.root) {
            fun bind(ExchRate: ExchangeRate) {
                binding.itemUnit.text = ExchRate.unit
                binding.itemValue.text = ExchRate.value
                Log.d("khy-adapter", "${ExchRate.unit} / ${ExchRate.value}")
                binding.executePendingBindings()
            }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExchRateListAdapter.ExchRateViewHolder {
        return ExchRateViewHolder(
            ExchRateListItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }


    override fun onBindViewHolder(holder: ExchRateViewHolder, position: Int) {
        val exchRate = getItem(position)
        holder.bind(exchRate)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ExchangeRate>() {

        override fun areItemsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate): Boolean {
            return oldItem.value == newItem.value
        }
    }//companion object DiffCallback

}