package com.example.weatherapp.koinDi

import android.content.Context
import android.util.JsonReader
import com.example.weatherapp.R
import com.example.weatherapp.dataSource.LocalData
import com.example.weatherapp.dataSource.LocalDataImpl
import com.example.weatherapp.model.Forecast
import com.example.weatherapp.model.Period
import org.koin.dsl.module


val localDataModule = module{

    fun getLocalData(): LocalData = LocalDataImpl()

    fun provideForecastPOJO(json: JsonReader, localData: LocalData): Forecast =
        localData.jsonToPojoConverter(json)

    fun provideLocalJsonData(path: String, context: Context, localData: LocalData):JsonReader =
        localData.getLocalJsonData(path, context)

    fun providePeriodData(forecast: Forecast): List<Period> = forecast.periods

    single { getLocalData() }
    single { provideForecastPOJO(get(), get()) }
    single { provideLocalJsonData(get(),get(), get()) }
    single { providePeriodData(get())}
}