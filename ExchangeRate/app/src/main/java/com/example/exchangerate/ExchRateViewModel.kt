package com.example.exchangerate

import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangerate.network.*
import kotlinx.coroutines.launch
import java.lang.Exception
import java.time.LocalDate
import java.time.LocalDate.now


class ExchRateViewModel: ViewModel() {

    private var _exchRate = MutableLiveData<List<ExchRate>>()
    var exchRate : LiveData<List<ExchRate>> = _exchRate

    private var DATE : String = ""
    lateinit var dateUrl : String

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

                dateUrl = getDate()
                Log.d("<khy-viewmodel> dateurl", dateUrl)
                var response= ExchRateApi.retrofitService.getExchRate(dateUrl)

                _exchRate.value = response.statisticSearch.row

                Log.d("<khy-exchrate>", "b: ${_exchRate.value!![0].value}")

            } catch (e: Exception){
                Log.d("<khy-viemodel>", "error: $e")

//                _exchRate.value = listOf()
            }
        }
    }




    private fun getDate(): String {
//        val recentBizDate: LocalDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            now()
//        } else {
//            TODO("VERSION.SDK_INT < O")
//        }

//        DATE = recentBizDate.toString()
        DATE = "20211029"

        Log.d("<khy>getDATE", DATE+"/"+DATE )

        return DATE
    }

    fun isValueValid(itemValue: String): Boolean{
        if(itemValue.isBlank()) return false
        return true
    }


}//ExchRateViewModel

