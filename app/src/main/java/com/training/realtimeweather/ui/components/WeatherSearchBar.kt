package com.training.realtimeweather.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.training.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun WeatherSearchBar(
    onSearch: (String) -> Unit
) {
    var city by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(16.dp),
            value = city,
            onValueChange = { city = it },
            label = { Text(" Search city") },
            singleLine = true,
            trailingIcon = {
                IconButton(
                    onClick = { onSearch(city) }) {
                    Icon(
                        imageVector = Icons.Rounded.Search, contentDescription = null
                    )
                }
            })
    }
}

@Composable
@Preview(showBackground = true)
fun WeatherSearchBarPreview() {
    RealTimeWeatherTheme() {
        WeatherSearchBar(onSearch = {})
    }
}