package com.manueldevmx.sunnyrainy_mvvm.network.api

import com.manueldevmx.sunnyrainy_mvvm.mainModule.model.CityEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface City {
    @GET("geo/1.0/reverse")
    suspend fun getCitiesByLatLng(
        @Query("lat") lat: String,
        lon: String,
        appid: String,
    ): Response<List<CityEntity>>
}