package com.example.exchangerate.network

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://ecos.bok.or.kr/api/StatisticSearch/2WACC588KULFVHKC0IED/json/kr/1/100/036Y001/DD/20211029/"

var FULL_URL = BASE_URL

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ExchRateApiService {
    @GET("20211029")
    suspend fun getExchRate() : StatisticSearch
}

object ExchRateApi{
    val retrofitService: ExchRateApiService by lazy {
        retrofit.create(ExchRateApiService::class.java)
    }
}

private fun setFullUrl():String{
//    val recentBizDate: LocalDate = now()

    val recentBizDate = "20211029"
    FULL_URL += recentBizDate+"/"+recentBizDate+"/"

    Log.d("<khy- apiservice>", "full url : ${FULL_URL}")
    return FULL_URL

}


//
//@RequiresApi(Build.VERSION_CODES.O)
//private fun getRecentBusinessDate(currentDate: LocalDate): LocalDate {
//    val recentDate: LocalDate = currentDate.minusDays(1)
//
//    return recentDate
//}