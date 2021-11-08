package com.example.exchangerate.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL =
    "https://ecos.bok.or.kr/api/StatisticSearch/2WACC588KULFVHKC0IED/json/kr/1/100/036Y001/DD/"

var FULL_URL = BASE_URL


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ExchRateApiService {
    @GET("{datetext}/{datetext}")
    suspend fun getExchRate(@Path("datetext") datetext: String ) : StatisticSearch

}

object ExchRateApi{
    val retrofitService: ExchRateApiService by lazy {
        retrofit.create(ExchRateApiService::class.java)
    }
}



//
//@RequiresApi(Build.VERSION_CODES.O)
//private fun getRecentBusinessDate(currentDate: LocalDate): LocalDate {
//    val recentDate: LocalDate = currentDate.minusDays(1)
//
//    return recentDate
//}