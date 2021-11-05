package com.example.exchangerate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerate.databinding.ExchRateListItemBinding
import com.example.exchangerate.network.ExchRate

class ExchRateListAdapter
    : ListAdapter<ExchRate, ExchRateListAdapter.ExchRateViewHolder>(DiffCallback) {


    class ExchRateViewHolder(private var binding: ExchRateListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ExchRate: ExchRate) {
            binding.exchRate = ExchRate
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

    override fun onBindViewHolder(holder: ExchRateListAdapter.ExchRateViewHolder, position: Int) {
        val exchRate = getItem(position)
        holder.bind(exchRate)
    }


    companion object DiffCallback : DiffUtil.ItemCallback<ExchRate>() {
        override fun areItemsTheSame(oldItem: ExchRate, newItem: ExchRate): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExchRate, newItem: ExchRate): Boolean {
            return oldItem.value == newItem.value
        }
    }


}