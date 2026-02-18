package com.training.realtimeweather.data.utils

sealed class WeatherException(errorMessage: String) : Exception(errorMessage) {
    class BadRequest(message: String) : WeatherException(message)
    class Unauthorized(message: String) : WeatherException(message)
    class NotFound(message: String) : WeatherException(message)
    class ServerError(message: String) : WeatherException(message)
    class NetworkError(message: String) : WeatherException(message)
    class Unknown(message: String) : WeatherException(message)
}