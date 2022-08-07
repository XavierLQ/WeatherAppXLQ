package com.example.weatherapp.views

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.RectangleShape
import com.example.weatherapp.model.Period

/**
 * This composable method handles the List<Periods>, which are each being populated into individual
 * [PeriodCards].
 */

@Composable
fun ForecastLazyColumn(periods: List<Period>){
    LazyColumn(
        Modifier.fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        items(periods){ period ->
            PeriodCard(period)
        }
    }
}





