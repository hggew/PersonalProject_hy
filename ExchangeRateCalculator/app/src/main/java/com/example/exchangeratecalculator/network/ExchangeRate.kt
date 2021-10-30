package com.example.exchangeratecalculator.network


import com.squareup.moshi.Json
import java.sql.Date

data class ExchangeRate (

    @Json(name = "ITEM_CODE1")
    val id: String,

    @Json(name = "ITEM_NAME1")
    val unit: String,

    @Json(name = "DATA_VALUE")
    val value: String,

    @Json(name = "TIME")
    val date: Date

)