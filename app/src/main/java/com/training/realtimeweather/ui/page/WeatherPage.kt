package com.training.realtimeweather.ui.page

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.training.realtimeweather.domain.entity.WeatherModelEntity
import com.training.realtimeweather.presentation.WeatherUiState
import com.training.realtimeweather.presentation.WeatherViewModel
import com.training.realtimeweather.ui.components.WeatherCardGrid
import com.training.realtimeweather.ui.components.WeatherSearchBar
import com.training.realtimeweather.ui.components.WeatherTemperature

@Composable
fun WeatherPage(
    modifier: Modifier,
    viewModel: WeatherViewModel
) {
    val uiState by viewModel.weatherUiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        WeatherSearchBar(
            onSearch = { location ->
                viewModel.getData(location)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (val result = uiState) {
            is WeatherUiState.Error -> {
                Text(result.message)
            }

            WeatherUiState.Ideal -> {
                Text("Enter City name to get weather details")
            }

            WeatherUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

            is WeatherUiState.Success -> {
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 })
                ) {
                    WeatherContent(result.weatherModel)
                }
            }
        }
    }
}


@Composable
fun WeatherContent(data: WeatherModelEntity) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        WeatherTemperature(data)

        Spacer(modifier = Modifier.height(8.dp))

        WeatherCardGrid(data)

    }
}
