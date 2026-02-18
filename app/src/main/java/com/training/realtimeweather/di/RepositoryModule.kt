package com.training.realtimeweather.di

import com.training.realtimeweather.data.repository.WeatherDataRepositoryImpl
import com.training.realtimeweather.domain.repository.WeatherDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(impl: WeatherDataRepositoryImpl): WeatherDataRepository
}