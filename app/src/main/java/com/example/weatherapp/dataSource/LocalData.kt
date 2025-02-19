package com.example.weatherapp.dataSource

import android.content.Context
import android.util.JsonReader
import com.example.weatherapp.R
import com.example.weatherapp.model.Forecast
import com.example.weatherapp.model.Period
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStream
import java.io.InputStreamReader

class LocalDataImpl: LocalData {

    /**
     * [localDataImpl] is used to hold all the functions that get the raw JSON data [getLocalJsonData],
     * convert that to POJOs [jsonToPojoConverter] and format by getting the period data [getPeriodData].
     *
     * These are sent to ViewModel which handles the communication with UI.
     */

    override fun jsonToPojoConverter(json: InputStream): Forecast {
        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<Forecast> = moshi.adapter(Forecast::class.java)
        return adapter.fromJson(json.bufferedReader().use{it.readText()})!!
    }

    override fun getLocalJsonData(context: Context):InputStream{
        val input: InputStream = context.resources.openRawResource(R.raw.weather)
        return input
    }

    override fun getPeriodData(forecast: Forecast): List<Period>{
        val periodList: List<Period> = forecast.periods
        return periodList
    }
}

interface LocalData{
    fun getPeriodData(forecast: Forecast): List<Period>
    fun getLocalJsonData(context: Context):InputStream
    fun jsonToPojoConverter(json: InputStream): Forecast
}