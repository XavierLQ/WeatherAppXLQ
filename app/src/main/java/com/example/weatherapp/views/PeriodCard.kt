package com.example.weatherapp.views

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import com.example.weatherapp.model.Period


/**
 * Each [PeriodCard] receives the [period] and displays all of its data in all the Text views.
 */

@Composable
fun PeriodCard(period: Period) {

    Column(
        Modifier.padding(all = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(text = "Name: ${period.name}")
        Text(text = "Temperature: ${period.temperature} ${period.temperatureUnit}")
        Text(text = "Wind Speed: ${period.windSpeed}")
        Text(text = "Wind Direction: ${period.windDirection}")
        Text(text = "Short Forecast: ${period.shortForecast}")
    }
}