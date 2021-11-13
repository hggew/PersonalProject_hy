package com.example.exchangerate

import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangerate.network.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class ExchRateViewModel : ViewModel() {

    private var _exchRate = MutableLiveData<List<ExchRate>>()
    var exchRate: LiveData<List<ExchRate>> = _exchRate

    var dateUrl: String? = null
    var dateUrlFromatted = ""

    var boo: Boolean = false


    fun getExchRate(date: String?) {

        viewModelScope.launch {
            try {
                runBlocking {
                    Log.d("<khy> dateurl/date ", "${dateUrl} + ${date}")

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        dateUrlFromatted =
                            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"))
                                .toString()
                    }

                    var response = ExchRateApi.retrofitService.getExchRate(date!!)

                    when(response.statisticSearch){
                        null -> boo = false
                        else -> boo = true
                    }

                    _exchRate.value = response.statisticSearch?.row
                }

            } catch (e: Exception) {
                Log.d("<khy-viemodel>", "error: $e")
            }
        }

    }


    fun isValueValid(itemValue: String): Boolean {
        if (itemValue.isBlank()) return false
        return true
    }


}//ExchRateViewModel

