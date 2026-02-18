package com.training.realtimeweather.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.realtimeweather.data.utils.WeatherException
import com.training.realtimeweather.domain.usecase.GetCurrentWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val useCase: GetCurrentWeatherDataUseCase
) : ViewModel() {

    private var _weatherUiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Ideal)
    val weatherUiState: StateFlow<WeatherUiState> = _weatherUiState

    fun getData(location: String) {
        Log.d("TAG", "getData: $location")
        _weatherUiState.value = WeatherUiState.Loading

        viewModelScope.launch {
            useCase(location)
                .catch { e ->
                    val message = when (e) {
                        is WeatherException.BadRequest -> e.message
                        is WeatherException.Unauthorized -> e.message
                        is WeatherException.NotFound -> e.message
                        is WeatherException.ServerError -> e.message
                        is WeatherException.NetworkError -> e.message
                        is WeatherException.Unknown -> e.message
                        else -> {
                            "An unexpected error occurred: ${e.message}"
                        }
                    }
                    _weatherUiState.value = WeatherUiState.Error(message ?: "Something went wrong")
                }.collectLatest { data ->
                    _weatherUiState.value = WeatherUiState.Success(data)
                }
        }
    }
}