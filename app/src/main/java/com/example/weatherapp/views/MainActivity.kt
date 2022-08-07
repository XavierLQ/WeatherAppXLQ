package com.example.weatherapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.weatherapp.R
import com.example.weatherapp.model.Period
import com.example.weatherapp.viewModel.ForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: ForecastViewModel by viewModel()
    var output = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getForecastPeriods()
        viewModel.forecastLiveData.observe(this){
            setContent {
                ForecastLazyColumn(it)
            }
        }
    }
}



