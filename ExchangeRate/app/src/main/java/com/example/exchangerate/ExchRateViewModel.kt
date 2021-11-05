package com.example.exchangerate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangerate.network.ExchRate
import com.example.exchangerate.network.ExchRateApi
import com.example.exchangerate.network.StatisticSearch
import kotlinx.coroutines.launch
import java.lang.Exception

class ExchRateViewModel: ViewModel() {

    private var _exchRate = MutableLiveData<List<ExchRate>>()
    var exchRate : LiveData<List<ExchRate>> = _exchRate


    init{
        Log.d("<khy-viewmodel>", "start view model")
        getExchRate()
    }

    private fun getExchRate(){
        Log.d("<khy-viewmodel>", "get exchange rate")

        viewModelScope.launch {
            try{
                Log.d("<khy-viewmodel>", "success launch")
//                _exchRate = ExchRateApi.retrofitService.getExchRate()
                var response= ExchRateApi.retrofitService.getExchRate()
                _exchRate.value = response.statisticSearch.row


                Log.d("<khy-exchrate>", "aa: ${getExchRateData()}")
                Log.d("<khy-exchrate>", "b: ${_exchRate.value!![0].value}")



            } catch (e: Exception){
                Log.d("<khy-viemodel>", "error: $e")

//                _exchRate.value = listOf()
            }
        }
    }

    fun getExchRateData(): String? {
        val aa = _exchRate.value?.get(1)?.value
        return aa
    }

}//ExchRateViewModel

