package com.example.exchangeratecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.exchangeratecalculator.databinding.FragmentChooseFuncBinding
import com.example.exchangeratecalculator.viewmodels.ExchRateCalcViewModel
import com.example.exchangeratecalculator.viewmodels.ExchRateCalcViewModelFactory

//import com.example.exchangeratecalculator.viewmodels.ExchRateCalcViewModelFactory


class ChooseFuncFragment : Fragment() {

    private var _binding: FragmentChooseFuncBinding? = null
    private val binding get() = _binding!!

//    private val viewModel: ExchRateCalcViewModel by activityViewModels()

    private val viewModel: ExchRateCalcViewModel by activityViewModels {
        ExchRateCalcViewModelFactory(
            (activity?.application as ExchRateCalcApplication).database.exchangeRateDao()
        )
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseFuncBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = this
        return binding.root
    }//onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.chooseFuncFragment = this

    }//onViewCreated

    fun goCalcFragment(){
        findNavController().navigate(R.id.action_chooseFuncFragment_to_calcExchangeRateFragment)

    }
    fun goExchRateFragment(){
        findNavController().navigate(R.id.action_chooseFuncFragment_to_exchRateListFragment)
    }
}



