package com.training.realtimeweather.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.training.realtimeweather.domain.entity.WeatherModelEntity
import com.training.realtimeweather.ui.components.WeatherCardGrid
import com.training.realtimeweather.ui.components.WeatherFeaturedDetails
import com.training.realtimeweather.ui.components.WeatherSearchBar

@Composable
fun WeatherPage(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel
) {
    val uiState by viewModel.weatherUiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
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

            null -> {}
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

        WeatherFeaturedDetails(data)

        Spacer(modifier = Modifier.height(8.dp))

        WeatherCardGrid(data)

    }
}
