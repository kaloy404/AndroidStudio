package com.mywaterapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) startWaterService()
        }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        askNotificationPermission()

        val drinkButton = findViewById<Button>(R.id.btnDrink)
        drinkButton.setOnClickListener {
            sendAddWaterCommand()
        }
    }

    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                        == PackageManager.PERMISSION_GRANTED -> startWaterService()

                else -> requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            startWaterService()
        }
    }

    private fun startWaterService() {
        val intent = Intent(this, WaterService::class.java)
        startForegroundService(intent)
    }

    private fun sendAddWaterCommand() {
        val intent = Intent(this, WaterService::class.java)
        intent.putExtra(WaterService.EXTRA_ADD_WATER, 250)
        startForegroundService(intent)
    }
}