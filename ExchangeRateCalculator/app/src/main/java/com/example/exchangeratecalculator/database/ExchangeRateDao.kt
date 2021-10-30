package com.example.exchangeratecalculator.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.sql.Date

@Dao
interface ExchangeRateDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ExChangeRateCalculator)

    @Update
    suspend fun update(item: ExChangeRateCalculator)

    @Delete
    suspend fun delete(item: ExChangeRateCalculator)


    @Query("SELECT value from exch_rate WHERE unit = :unit")
    fun getValue(unit: String): Flow<ExChangeRateCalculator>

    @Query("SELECT DISTINCT date from exch_rate")
    fun getDate(unit: String): Date

}