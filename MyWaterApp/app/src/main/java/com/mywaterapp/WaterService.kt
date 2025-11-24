package com.mywaterapp

import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.os.*
import androidx.core.app.NotificationCompat

class WaterService : Service() {

    companion object {
        const val NOTIFICATION_ID = 1
        const val CHANNEL_ID = "water_channel"
        const val EXTRA_ADD_WATER = "add_water"
    }

    private var waterLevel = 2500.0  // starting balanced state
    private val handler = Handler(Looper.getMainLooper())
    private val decreaseTask = object : Runnable {
        override fun run() {
            waterLevel -= 0.144   // decrease every 5 seconds
            updateNotification()

            handler.postDelayed(this, 5000)
        }
    }

    @SuppressLint("ForegroundServiceType")
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        startForeground(NOTIFICATION_ID, createNotification())
        handler.post(decreaseTask)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val addedWater = intent?.getIntExtra(EXTRA_ADD_WATER, 0) ?: 0

        if (addedWater > 0) {
            waterLevel += addedWater
            updateNotification()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        handler.removeCallbacks(decreaseTask)
        super.onDestroy()
    }

    override fun onBind(intent: Intent?) = null

    private fun createNotification(): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("My Water Tracker")
            .setContentText("Current balance: ${"%.2f".format(waterLevel)} ml")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
    }

    private fun updateNotification() {
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("My Water Tracker")
            .setContentText("Current balance: ${"%.2f".format(waterLevel)} ml")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Water Tracker Channel",
            NotificationManager.IMPORTANCE_LOW
        )
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }
}