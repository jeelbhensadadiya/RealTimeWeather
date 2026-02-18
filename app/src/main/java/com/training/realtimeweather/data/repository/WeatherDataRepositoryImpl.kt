package com.training.realtimeweather.data.repository

import com.training.realtimeweather.data.mapper.toDomain
import com.training.realtimeweather.data.remote.api.WeatherService
import com.training.realtimeweather.data.utils.WeatherException
import com.training.realtimeweather.domain.entity.WeatherModelEntity
import com.training.realtimeweather.domain.repository.WeatherDataRepository
import com.training.realtimeweather.utils.Config.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class WeatherDataRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService
) : WeatherDataRepository {

    override suspend fun getWeatherData(location: String): Flow<WeatherModelEntity> {
        return flow {
            try {
                val response = weatherService.getCurrentWeather(
                    apiKey = API_KEY,
                    city = location,
                    aqi = "no"
                )

                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        emit(body.toDomain())
                    } else {
                        throw WeatherException.Unknown("Empty Response from Server")
                    }
                } else {
                    when (response.code()) {
                        400 -> throw WeatherException.BadRequest("Invalid location format.")
                        401 -> throw WeatherException.Unauthorized("Invalid API key.")
                        403 -> throw WeatherException.NotFound("API key has exceeded calls per month quota.")
                        404 -> throw WeatherException.NotFound("Weather data not found.")
                        500 -> throw WeatherException.ServerError("Server error. Please try again later.")
                        else -> throw WeatherException.Unknown("Unexpected error: ${response.code()}")
                    }
                }
            } catch (e: UnknownHostException) {
                throw WeatherException.NetworkError("No internet connection")
            } catch (e: SocketTimeoutException) {
                throw WeatherException.NetworkError("Connection timed out")
            } catch (e: Exception) {
                throw WeatherException.Unknown(e.message ?: "Unexpected error")
            }
        }.flowOn(Dispatchers.IO)
    }
}