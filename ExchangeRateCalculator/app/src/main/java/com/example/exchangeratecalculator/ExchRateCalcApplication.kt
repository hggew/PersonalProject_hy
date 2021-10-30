package com.example.exchangeratecalculator

import android.app.Application
import com.example.exchangeratecalculator.database.AppDatabase

class ExchRateCalcApplication: Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}