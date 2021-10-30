package com.example.exchangeratecalculator.network

import android.os.Build
import androidx.annotation.RequiresApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.time.LocalDate
import java.time.LocalDate.now


private const val BASE_URL =
    "https://ecos.bok.or.kr/api/StatisticSearch/2WACC588KULFVHKC0IED/json/kr/1/100/036Y001/DD/"

lateinit var FULL_URL: String

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


@RequiresApi(Build.VERSION_CODES.O)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(setFullUrl())
    .build()


interface ExchangeRateApiService {
    @GET()
    suspend fun getExchangeRate() : List<ExchangeRate>
}

@RequiresApi(Build.VERSION_CODES.O)
object ExchangeRateApi{
    val retrofitService: ExchangeRateApiService by lazy {
        retrofit.create(ExchangeRateApiService::class.java)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun setFullUrl():String{
    val recentBizDate: LocalDate = now()

    FULL_URL = BASE_URL+recentBizDate+"/"+recentBizDate

    return FULL_URL

}


//
//@RequiresApi(Build.VERSION_CODES.O)
//private fun getRecentBusinessDate(currentDate: LocalDate): LocalDate {
//    val recentDate: LocalDate = currentDate.minusDays(1)
//
//    return recentDate
//}