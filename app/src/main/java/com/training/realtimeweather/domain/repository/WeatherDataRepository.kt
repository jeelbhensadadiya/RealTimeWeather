package com.training.realtimeweather.domain.repository

import com.training.realtimeweather.domain.entity.WeatherModelEntity
import kotlinx.coroutines.flow.Flow

interface WeatherDataRepository {

    suspend fun getWeatherData(location: String): Flow<WeatherModelEntity>
}