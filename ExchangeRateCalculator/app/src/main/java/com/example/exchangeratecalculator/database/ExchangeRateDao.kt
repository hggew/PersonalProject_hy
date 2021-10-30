package com.example.exchangeratecalculator.database

import androidx.room.*

@Dao
interface ExchangeRateDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(exchangeRate: ExchangeRateDb)
//before room call coroutin, SUSPEND is not available

//    @Update
//    suspend fun update(item: ExChangeRateCalculator)
//
//    @Delete
//    suspend fun delete(item: ExChangeRateCalculator)


    @Query("SELECT value from exch_rate WHERE unit = :unit")
    fun getValue(unit: String): Double

    @Query("SELECT DISTINCT date from exch_rate")
    fun getDate(): String

}