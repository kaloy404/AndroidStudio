package com.weatherapp.data.network

import com.weatherapp.data.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherManager (
    private val api: OpenWeatherApi,
    private val apiKey: String
    )
{
        // Function to get weather for any city
        suspend fun getWeather(city: String): WeatherResponse?{
            return try {
                withContext(Dispatchers.IO) {
                    api.getWeather(city, apiKey)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
}