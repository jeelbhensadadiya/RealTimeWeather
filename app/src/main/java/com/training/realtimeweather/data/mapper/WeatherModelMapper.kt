package com.training.realtimeweather.data.mapper

import com.training.realtimeweather.data.entity.dto.Condition
import com.training.realtimeweather.data.entity.dto.Current
import com.training.realtimeweather.data.entity.dto.Location
import com.training.realtimeweather.data.entity.dto.WeatherModel
import com.training.realtimeweather.domain.entity.ConditionEntity
import com.training.realtimeweather.domain.entity.CurrentEntity
import com.training.realtimeweather.domain.entity.LocationEntity
import com.training.realtimeweather.domain.entity.WeatherModelEntity

// Mapper functions to convert data models to domain entities

fun WeatherModel.toDomain(): WeatherModelEntity {
    return WeatherModelEntity(
        current = current.toDomain(),
        location = location.toDomain()
    )
}

fun Location.toDomain(): LocationEntity {
    return LocationEntity(
        country = country,
        lat = lat,
        localtime = localtime,
        localtime_epoch = localtime_epoch,
        lon = lon,
        name = name,
        region = region,
        tz_id = tz_id
    )
}

fun Current.toDomain(): CurrentEntity {
    return CurrentEntity(
        cloud = cloud,
        dewpoint_c = dewpoint_c,
        dewpoint_f = dewpoint_f,
        feelslike_c = feelslike_c,
        feelslike_f = feelslike_f,
        heatindex_c = heatindex_c,
        heatindex_f = heatindex_f,
        humidity = humidity,
        is_day = is_day,
        last_updated = last_updated,
        last_updated_epoch = last_updated_epoch,
        precip_in = precip_in,
        precip_mm = precip_mm,
        pressure_in = pressure_in,
        pressure_mb = pressure_mb,
        temp_c = temp_c,
        temp_f = temp_f,
        wind_degree = wind_degree,
        wind_dir = wind_dir,
        wind_kph = wind_kph,
        wind_mph = wind_mph,
        windchill_c = windchill_c,
        condition = condition.toDomain(),
        gust_kph = gust_kph,
        gust_mph = gust_mph,
        uv = uv,
        vis_km = vis_km,
        vis_miles = vis_miles,
        windchill_f = windchill_f,
    )
}

fun Condition.toDomain(): ConditionEntity {
    return ConditionEntity(
        code = code,
        icon = icon,
        text = text
    )
}

// Extension functions to convert domain entities back to data models (if needed)

fun WeatherModelEntity.toData(): WeatherModel {
    return WeatherModel(
        current = current.toData(),
        location = location.toData()
    )
}

fun LocationEntity.toData(): Location {
    return Location(
        country = country,
        lat = lat,
        localtime = localtime,
        localtime_epoch = localtime_epoch,
        lon = lon,
        name = name,
        region = region,
        tz_id = tz_id
    )
}

fun CurrentEntity.toData(): Current {
    return Current(
        cloud = cloud,
        dewpoint_c = dewpoint_c,
        dewpoint_f = dewpoint_f,
        feelslike_c = feelslike_c,
        feelslike_f = feelslike_f,
        heatindex_c = heatindex_c,
        heatindex_f = heatindex_f,
        humidity = humidity,
        is_day = is_day,
        last_updated = last_updated,
        last_updated_epoch = last_updated_epoch,
        precip_in = precip_in,
        precip_mm = precip_mm,
        pressure_in = pressure_in,
        pressure_mb = pressure_mb,
        temp_c = temp_c,
        temp_f = temp_f,
        wind_degree = wind_degree,
        wind_dir = wind_dir,
        wind_kph = wind_kph,
        wind_mph = wind_mph,
        windchill_c = windchill_c,
        condition = condition.toData(),
        gust_kph = gust_kph,
        gust_mph = gust_mph,
        uv = uv,
        vis_km = vis_km,
        vis_miles = vis_miles,
        windchill_f = windchill_f
    )
}

fun ConditionEntity.toData(): Condition {
    return Condition(
        code = code,
        icon = icon,
        text = text
    )
}