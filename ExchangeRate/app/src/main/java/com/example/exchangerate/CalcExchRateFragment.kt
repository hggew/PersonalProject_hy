package com.example.exchangerate

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.exchangerate.databinding.FragmentCalcExchRateBinding

class CalcExchRateFragment : Fragment() {

    private var _binding: FragmentCalcExchRateBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ExchRateViewModel by viewModels()

    var inputSelectUnit : String = ""
    var outputSelectUnit : String = ""
    var inputValue : Double = 0.0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentCalcExchRateBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        binding.recyclerView.adapter= CalcExchRateAdapter()

        var unitData = resources.getStringArray(R.array.unit)


//        spinner.adapter = ArrayAdapter(requireContext(),
//            R.layout.support_simple_spinner_dropdown_item,
//            unitData) as SpinnerAdapter

        ///// Input Spinner /////
        val inputSpinner = binding.itemInputUnit

        inputSpinner.adapter = activity?.let {
            ArrayAdapter(it,
                R.layout.support_simple_spinner_dropdown_item,
                unitData)
        } as SpinnerAdapter

        inputSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                inputSelectUnit = parent?.getItemAtPosition(position).toString()
                Log.d("<khy> spinner in", inputSelectUnit )
            }
        }


        ///// Output Spinner /////
        val outputSpinner = binding.itemOutputUnit

        outputSpinner.adapter = activity?.let {
            ArrayAdapter(it,
                R.layout.support_simple_spinner_dropdown_item,
                unitData)
        } as SpinnerAdapter

        outputSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                outputSelectUnit = parent?.getItemAtPosition(position).toString()
                Log.d("<khy> spinner out", outputSelectUnit)
//                Log.d("<khy> spinner out", position.toString())

            }
        }

        ///// btn /////
        binding.btnCalc.setOnClickListener{
            calcExchRate()
        }



        return binding.root
    } //OnCreateView

    fun calcExchRate(){
        Log.d("<khy> calcbtn","${inputSelectUnit} / ${outputSelectUnit}")

        if (isValueValid()){
            inputValue = binding.itemInputValue.text.toString().toDouble()
            Log.d("<khy> calcbtn", inputValue.toString())


//            if(inputSelectUnit.equals("한화")){ }

        }
        else{
            Log.d("<khy> calcbtn", "input number")
        }
    }

    fun isValueValid():Boolean{
        return viewModel.isValueValid(
            binding.itemInputValue.text.toString()
        )
    }

//    fun findUnitIndex(){
//                Log.d("<khy> list", "${_exchRate.value!!.size}")
//        for(i in viewModel.exchRate.value!!){
//
//        }
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }




}