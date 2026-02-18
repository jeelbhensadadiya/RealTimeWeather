package com.training.realtimeweather.domain.entity

data class WeatherModelEntity(
    val current: CurrentEntity,
    val location: LocationEntity
)