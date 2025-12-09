package com.lab41.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lab41.R

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        val text = findViewById<TextView>(R.id.displayText)
        val txt = intent?.getStringExtra(Activity2.EXTRA_ITEM_TEXT) ?: ""
        text.text = txt
    }
}