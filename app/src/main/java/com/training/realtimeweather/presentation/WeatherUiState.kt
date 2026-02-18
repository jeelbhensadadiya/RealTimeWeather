package com.training.realtimeweather.presentation

import com.training.realtimeweather.domain.entity.WeatherModelEntity

sealed class WeatherUiState {
    object Ideal : WeatherUiState()
    object Loading : WeatherUiState()
    data class Success(val weatherModel: WeatherModelEntity) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}
