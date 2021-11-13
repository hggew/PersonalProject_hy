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
import androidx.fragment.app.activityViewModels
import com.example.exchangerate.databinding.FragmentCalcExchRateBinding
import kotlin.math.round

class CalcExchRateFragment : Fragment() {

    private var _binding: FragmentCalcExchRateBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ExchRateViewModel by activityViewModels()

    var selectInput = selectExchRate()
    var selectOutnput = selectExchRate()

    var inputValue: Double = 0.0
    var result : Double = 0.0

    data class selectExchRate(
        var unit: String = "",
        var value : Double = 1.0
    )



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentCalcExchRateBinding.inflate(inflater, container, false)
        return binding.root
    } //OnCreateView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.layout.setOnClickListener { closeKeyboard() }

        var unitData = resources.getStringArray(R.array.unit)       //스피너 리스트


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
                selectInput.unit = parent?.getItemAtPosition(position).toString()
                Log.d("<khy> spinner in", selectInput.unit)
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
                selectOutnput.unit = parent?.getItemAtPosition(position).toString()
                Log.d("<khy> spinner out", selectOutnput.unit)
            }
        }


        ///// btn /////
        binding.btnCalc.setOnClickListener {
            calcExchRate()
            closeKeyboard()
        }

    }//onViewCreated




    fun calcExchRate() {

        if (isValueValid()) {
            inputValue = binding.itemInputValue.text.toString().toDouble()

            findUnitValue(selectInput)
            findUnitValue(selectOutnput)
            Log.d("<khy> in/out value : ", "${selectInput.value.toString()} / ${selectOutnput.value.toString()}" )

            result = selectInput.value * inputValue / selectOutnput.value
            Log.d("<khy> result : ", result.toString())

            binding.itemOutputValue.text = (round(result*100)/100).toString()

        } else {
            Log.d("<khy> calcbtn", "input number")
        }
    }

    fun isValueValid(): Boolean {
        return viewModel.isValueValid(
            binding.itemInputValue.text.toString()
        )
    }


    fun findUnitValue(selected : CalcExchRateFragment.selectExchRate) {
        var findValue : Double = 1.0  //한화일때 기본값=1

        for ( exchRateList in viewModel.exchRate.value!!) {
            if (exchRateList.unit.contains(selected.unit)){
                findValue = exchRateList.value.toDouble()
                break
            }
        }
        selected.value = findValue
    }//findUnitValue


    fun closeKeyboard(){
        var view = requireActivity().currentFocus

        if (view != null){
            val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }




}

