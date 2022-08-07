package com.example.weatherapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.model.Period


@Composable
fun PeriodCard(period: Period) {

    Column(modifier = Modifier.padding(all = 10.dp)) {
        Text(text = "Name: ${period.name}")
        Text(text = "Temperature: ${period.temperature} ${period.temperatureUnit}")
        Text(text = "Wind Speed: ${period.windSpeed}")
        Text(text = "Wind Direction: ${period.windDirection}")
        Text(text = "Short Forecast: ${period.shortForecast}")
        Text(text = "Long Forecast: ${period.longForecast}")
    }
}