package com.training.realtimeweather.domain.usecase

import com.training.realtimeweather.domain.repository.WeatherDataRepository
import javax.inject.Inject

class GetCurrentWeatherDataUseCase @Inject constructor(
    private val repository: WeatherDataRepository
) {
    suspend operator fun invoke(location: String) =
        repository.getWeatherData(location)
}