package com.training.realtimeweather.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.training.realtimeweather.domain.entity.WeatherModelEntity

@Composable
fun WeatherTemperature(data: WeatherModelEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.padding(end = 8.dp),
            imageVector = Icons.Outlined.LocationOn,
            contentDescription = null,
        )
        Text(
            text = "${data.location.name}, ${data.location.country}",
            style = MaterialTheme.typography.titleLarge
        )
    }
    Text(
        text = "${data.current.temp_c} °C",
        style = MaterialTheme.typography.displayLarge
    )
    AsyncImage(
        modifier = Modifier.size(100.dp),
        model = "https:${data.current.condition.icon}",
        contentDescription = "ConditionEntity Icon",
    )
    Text(
        text = data.current.condition.text,
        style = MaterialTheme.typography.titleMedium
    )
}
