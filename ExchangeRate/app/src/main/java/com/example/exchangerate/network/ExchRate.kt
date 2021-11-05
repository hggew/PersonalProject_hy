package com.example.exchangerate.network

import com.squareup.moshi.Json

data class StatisticSearch(
    @Json(name = "StatisticSearch")
    val statisticSearch: Row
)

//data class ListTotalCount(
//    @Json(name = "list_total_count")
//    val listTotalCount: Row
//)

data class Row(
    @Json(name = "row")
    val row : List<ExchRate>
)

data class ExchRate (

    @Json(name = "ITEM_CODE1")
    val id: Int,

    @Json(name = "ITEM_NAME1")
    val unit: String,

    @Json(name = "DATA_VALUE")
    val value: String,

    @Json(name = "TIME")
    val date: String

)