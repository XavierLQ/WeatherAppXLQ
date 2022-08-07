package com.example.weatherapp.koinDi

import com.example.weatherapp.viewModel.ForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * This [viewModelModule] handles the dependencies of the viewModel
 */

val viewModelModule = module{
    viewModel { ForecastViewModel(get()) }
}