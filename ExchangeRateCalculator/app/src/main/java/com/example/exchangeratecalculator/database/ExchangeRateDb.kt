package com.example.exchangeratecalculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="exch_rate")
data class ExchangeRateDb (
    @PrimaryKey(autoGenerate= true) val id:Int = 0,
    @ColumnInfo(name = "unit") val unit: String,
    @ColumnInfo(name = "value") val value: Double,
    @ColumnInfo(name = "date") val date: String //여기 고쳐야함. 나도몰랏ㅄㅄㅄ
    

    )