package com.example.exchangeratecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangeratecalculator.databinding.FragmentExchRateListBinding
import com.example.exchangeratecalculator.viewmodels.ExchRateCalcViewModel
import com.example.exchangeratecalculator.viewmodels.ExchRateCalcViewModelFactory

//import com.example.exchangeratecalculator.viewmodels.ExchRateCalcViewModelFactory

class ExchRateListFragment: Fragment() {

    private var _binding: FragmentExchRateListBinding? = null
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
        _binding = FragmentExchRateListBinding.inflate(inflater,container, false)
//        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }//onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ExchRateListAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.exchangeRate.observe(this.viewLifecycleOwner){
                items -> items.let { adapter.submitList(it) }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)




    }//onViewCreated

}