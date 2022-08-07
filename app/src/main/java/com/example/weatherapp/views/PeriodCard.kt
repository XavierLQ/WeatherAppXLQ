package com.example.weatherapp.views

import androidx.compose.runtime.Composable
import com.example.weatherapp.model.Period


@Composable
fun PeriodCard(period: Period) {

    val name: String = period.name
    val temp: String = period.temperature.toString()
    val tempUnit: String = period.temperatureUnit
    val windSpeed: String = period.windSpeed
    val windDir: String = period.windDirection
    val shortForecast: String = period.shortForecast
    val longForecast: String = period.longForecast



}