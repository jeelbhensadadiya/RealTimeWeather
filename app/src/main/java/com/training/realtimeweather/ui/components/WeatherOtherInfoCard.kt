package com.training.realtimeweather.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.training.realtimeweather.ui.theme.RealTimeWeatherTheme


@Composable
fun WeatherOtherInfoCard(
    key: String,
    value: String
) {
    Card(
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium
            )
            Text(key)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WeatherOtherInfoCardPreview() {
    RealTimeWeatherTheme {
        WeatherOtherInfoCard(
            key = "Wind Speed",
            value = "10 km/h"
        )
    }
}