//package com.example.exchangeratecalculator
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.ListAdapter
//import androidx.recyclerview.widget.DiffUtil
//import com.example.exchangeratecalculator.database.ExchangeRateDb
//import com.example.exchangeratecalculator.databinding.FragmentChooseFuncBinding
//
//class ChooseFuncAdapter(private val onClicked: (ExchangeRateDb) -> Unit) :
//ListAdapter<ExchangeRateDb, ChooseFuncAdapter.ExchangeRateCalculatorViewHolder>(DiffCallback){
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
//    : ExchangeRateCalculatorViewHolder {
//        return ExchangeRateCalculatorViewHolder(
//            ItemListItemBinding.inflate(
//                LayoutInflater.from( parent.context )
//            )
//        )
//    }
//
//    class ExchangeRateCalculatorViewHolder(private val binding: FragmentChooseFuncBinding) {
//
//    }
//
//
//    companion object {
//        private val DiffCallback = object : DiffUtil.ItemCallback<ExchangeRateDb>(){
//            override fun areItemsTheSame(
//                oldItem: ExchangeRateDb,
//                newItem: ExchangeRateDb
//            ): Boolean {
////                return oldItem === newItem
//            }
//
//            override fun areContentsTheSame(
//                oldItem: ExchangeRateDb,
//                newItem: ExchangeRateDb
//            ): Boolean {
////                return oldItem.unit == newItem.itemName
//            }
//
//        }
//    }
//
//
//}