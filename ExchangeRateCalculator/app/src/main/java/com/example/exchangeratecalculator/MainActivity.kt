package com.example.exchangeratecalculator

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exchangeratecalculator.network.ExchangeRate
import com.example.exchangeratecalculator.network.ExchangeRateApiService
import com.example.exchangeratecalculator.network.FULL_URL

class MainActivity : AppCompatActivity() {


    //navigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("<khy-main>","start main activity")

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)




    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}