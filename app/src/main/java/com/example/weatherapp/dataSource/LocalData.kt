package com.example.weatherapp.dataSource

import android.content.Context
import android.util.JsonReader
import com.example.weatherapp.R
import com.example.weatherapp.model.Forecast
import com.example.weatherapp.model.Period
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.io.InputStream
import java.io.InputStreamReader

class LocalDataImpl: LocalData {

    override fun jsonToPojoConverter(json: JsonReader): Forecast {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<Forecast> = moshi.adapter(Forecast::class.java)
        return adapter.fromJson(json.toString())!!
    }

    override fun getLocalJsonData(path: String, context: Context):JsonReader{
        val input: InputStream = context.resources.openRawResource(R.raw.weather)
        val json = JsonReader(InputStreamReader(input))
        return json
    }

    override fun getPeriodData(forecast: Forecast): List<Period>{
        val periodList: List<Period> = forecast.periods
        return periodList
    }

    companion object{
        const val weatherJsonPath = "weather.json"
    }
}

interface LocalData{
    fun getPeriodData(forecast: Forecast): List<Period>
    fun getLocalJsonData(path: String, context: Context):JsonReader
    fun jsonToPojoConverter(json: JsonReader): Forecast
}