package com.example.weatherapp.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherapp.model.Period

@Composable
fun ForecastLazyColumn(periods: List<Period>){
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(periods){ period ->
            PeriodCard(period)
        }
    }
}


