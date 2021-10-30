package com.example.exchangeratecalculator.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.exchangeratecalculator.database.ExchangeRateDao
import com.example.exchangeratecalculator.network.ExchangeRate
import com.example.exchangeratecalculator.network.ExchangeRateApi
import kotlinx.coroutines.launch


class ExchangeRateCalculatorViewModel(private val exchangeRateDao: ExchangeRateDao) : ViewModel() {

    private val _exchangeRate = MutableLiveData<List<ExchangeRate>>()
    val exchangeRate: LiveData<List<ExchangeRate>> = _exchangeRate


    init {
        Log.d("<main activity>", "start view model")
        getExchangeRate()
    }


    private fun getExchangeRate() {

        Log.d("<main activity>", "get exchange rate")
        viewModelScope.launch {
            try {
                _exchangeRate.value = ExchangeRateApi.retrofitService.getExchangeRate()
                Log.d("<main activity>", "success launch")
//                Log.d("<main activity>", "${_exchangeRate.value!![0].unit}")
            } catch (e: Exception) {
                Log.d("<main activity>", "fail launch")
            }
        }
    }
}//ExchangeRateCalculatorViewModel

class ExchangeRateCalculatorViewModelFactory(private val exchangeRateDao: ExchangeRateDao) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExchangeRateCalculatorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExchangeRateCalculatorViewModel(exchangeRateDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}