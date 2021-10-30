package com.example.exchangeratecalculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName ="exch_rate")
data class ExChangeRateCalculator (
    @PrimaryKey(autoGenerate= true) val id:Int = 0,
    @ColumnInfo(name = "unit") val unit: String,
    @ColumnInfo(name = "value") val value: Double,
    @ColumnInfo(name = "date") val date: Date //여기 고쳐야함. 나도몰랏ㅄㅄㅄ
    

    )