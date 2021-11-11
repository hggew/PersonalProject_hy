package com.example.exchangerate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.exchangerate.databinding.FragmentExchRateListBinding

class ExchRateListFragment : Fragment() {

    private val viewModel: ExchRateViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentExchRateListBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = ExchRateListAdapter()

        if (viewModel.exchRate == null) {
            Log.d("<khy null>", "null")
//            Toast.makeText(requireContext(), "choose date again!", Toast.LENGTH_SHORT).show()
        } else {
            Log.d("<khy null>", "goooooooooooooooood")
        }



        return binding.root
    }

}