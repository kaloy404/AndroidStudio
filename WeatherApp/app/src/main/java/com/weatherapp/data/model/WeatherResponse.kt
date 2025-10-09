package com.weatherapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    val name: String,           // city name
    val weather: List<Weather>  // list of weather info
)
@JsonClass(generateAdapter = true)
data class Weather(
    val main: String,           // short description, e.g., "Clouds"
    val description: String,    // longer description, e.g., "broken clouds"
    val icon: String            // icon code, e.g., "04d"
)