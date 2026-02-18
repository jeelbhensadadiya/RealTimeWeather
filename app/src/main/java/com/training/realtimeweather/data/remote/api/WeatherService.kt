package com.training.realtimeweather.data.remote.api

import com.training.realtimeweather.data.entity.dto.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no",
    ): Response<WeatherModel>
}