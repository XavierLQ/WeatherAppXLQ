package com.example.weatherapp.koinDi

import com.example.weatherapp.viewModel.ForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { ForecastViewModel() }
}