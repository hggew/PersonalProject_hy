package com.example.exchangerate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exchangerate.databinding.FragmentChooseFuncBinding

class ChooseFuncFragment : Fragment() {

//    private val viewModel: ExchRateViewModel by viewModels()

    private var binding : FragmentChooseFuncBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentChooseFuncBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }//onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chooseFuncFragment = this
    }

    fun goCalcFragment(){
        findNavController().navigate(R.id.action_chooseFuncFragment_to_calcExchRateFragment)

    }
    fun goExchRateFragment(){
        findNavController().navigate(R.id.action_chooseFuncFragment_to_exchRateListFragment )
    }
}