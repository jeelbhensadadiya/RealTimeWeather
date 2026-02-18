package com.training.realtimeweather.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.training.realtimeweather.domain.entity.WeatherModelEntity

@Composable
fun WeatherCardGrid(data: WeatherModelEntity) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        columns = GridCells.Adaptive(150.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            WeatherOtherInfoCard(
                key = "Wind",
                value = "${data.current.wind_kph} km/h"
            )
        }
        item {
            WeatherOtherInfoCard(
                key = "Humidity",
                value = "${data.current.humidity}%"
            )
        }
        item {
            WeatherOtherInfoCard(
                key = "Pressure",
                value = "${data.current.pressure_mb} mb"
            )
        }
        item {
            WeatherOtherInfoCard(
                key = "UV Index",
                value = data.current.uv
            )
        }
        item {
            WeatherOtherInfoCard(
                key = "Visibility",
                value = "${data.current.vis_km} km"
            )
        }
        item {
            WeatherOtherInfoCard(
                key = "Cloud Cover",
                value = "${data.current.cloud}%"
            )
        }
    }
}
