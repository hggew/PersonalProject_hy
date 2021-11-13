package com.example.exchangerate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exchangerate.databinding.FragmentChooseFuncBinding

class ChooseFuncFragment : Fragment() {

    private var _binding: FragmentChooseFuncBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseFuncBinding.inflate(inflater, container, false)
        return binding.root
    }//onCreateView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chooseFuncFragment = this
    }


    fun goCalcFragment(){
        val action = ChooseFuncFragmentDirections.actionChooseFuncFragmentToCalendarFragment(1)
        findNavController().navigate(action)
    }


    fun goExchRateFragment(){
        val action = ChooseFuncFragmentDirections.actionChooseFuncFragmentToCalendarFragment(2)
        findNavController().navigate(action)
    }

}