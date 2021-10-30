package com.example.exchangeratecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.exchangeratecalculator.databinding.FragmentChooseFuncBinding
import com.example.exchangeratecalculator.viewmodels.ExchangeRateCalculatorViewModel

class ChooseFuncFragment : Fragment() {

    private var _binding: FragmentChooseFuncBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: ExchangeRateCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseFuncBinding.inflate(inflater,container,false)
        return binding.root
    }
}