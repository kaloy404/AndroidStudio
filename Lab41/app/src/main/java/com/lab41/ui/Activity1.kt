package com.lab41.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.lab41.R

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val numberEdit = findViewById<EditText>(R.id.numberEdit)
        val goButton = findViewById<Button>(R.id.goButton)

        goButton.setOnClickListener {
            val number = numberEdit.text.toString().toIntOrNull() ?: 0
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra(Activity2.EXTRA_COUNT, number)
            startActivity(intent)
        }
    }
}