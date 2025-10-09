package com.weatherapp.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.weatherapp.R
import com.weatherapp.data.network.ApiClient
import com.weatherapp.data.network.WeatherManager
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val apiKey = "865fe0843ce7fee65256c0b380669e38"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = WeatherManager(ApiClient.apiService, apiKey)
        val city = findViewById<TextView>(R.id.tvCity)
        val main = findViewById<TextView>(R.id.tvMain)
        val description = findViewById<TextView>(R.id.tvDescription)
        val imgWeather = findViewById<ImageView>(R.id.imgWeather)

        lifecycleScope.launch {
            try {
                val result = manager.getWeather("New York")

                if (result != null) {
                    val weather = result.weather.firstOrNull()
                    city.text = result.name
                    main.text = weather?.main ?: "N/A"
                    description.text = weather?.description ?: "No description"

                    val iconUrl = "https://openweathermap.org/img/wn/${weather?.icon}@2x.png"
                    Glide.with(this@MainActivity)
                        .load(iconUrl)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(imgWeather)
                    println("Icon Code: ${weather?.icon}")
                    println("Full URL: $iconUrl")
                } else {
                    main.text = "No data"
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
