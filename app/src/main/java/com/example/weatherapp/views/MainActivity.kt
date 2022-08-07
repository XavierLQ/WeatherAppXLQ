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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * This part handles the communication with the [viewModel], which observes the data that is
         * being stored into the liveData.
         */

        viewModel.getForecastPeriods()
        viewModel.forecastLiveData.observe(this){
            /**
             * This part handles the composable UI components from Jetpack compose, by calling the
             * [ForecastLazyColumnt] which is using the data received from the liveData.
             */
            setContent {
                ForecastLazyColumn(it)
            }
        }
    }
}



