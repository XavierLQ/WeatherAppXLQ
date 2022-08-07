package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Period(
    @Json(name = "longForecast")
    val longForecast: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "shortForecast")
    val shortForecast: String,
    @Json(name = "temperature")
    val temperature: Int,
    @Json(name = "temperatureUnit")
    val temperatureUnit: String,
    @Json(name = "windDirection")
    val windDirection: String,
    @Json(name = "windSpeed")
    val windSpeed: String
)