package com.example.exchangerate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.exchangerate.databinding.FragmentChooseFuncBinding

class ChooseFuncFragment : Fragment() {


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
        val action = ChooseFuncFragmentDirections.actionChooseFuncFragmentToCalendarFragment(1)
        findNavController().navigate(action)
    }

    fun goExchRateFragment(){
        val action = ChooseFuncFragmentDirections.actionChooseFuncFragmentToCalendarFragment(2)
        findNavController().navigate(action)
    }

}