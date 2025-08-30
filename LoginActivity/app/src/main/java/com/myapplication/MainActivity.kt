package com.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titleText: TextView
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: Button
    private lateinit var resultMessage: TextView

    // Hardcoded credentials
    private val VALID_USERNAME = "admin"
    private val VALID_PASSWORD = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText = findViewById(R.id.titleText)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginBtn = findViewById(R.id.loginBtn)
        resultMessage = findViewById(R.id.resultMessage)

        loginBtn.setOnClickListener {
            val userInput = username.text.toString().trim()
            val passInput = password.text.toString().trim()

            // Validate empty fields
            if (userInput.isEmpty() || passInput.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check credentials
            if (userInput == VALID_USERNAME && passInput == VALID_PASSWORD) {

                titleText.visibility = View.GONE
                username.visibility = View.GONE
                password.visibility = View.GONE
                loginBtn.visibility = View.GONE

                resultMessage.visibility = View.VISIBLE
                resultMessage.text = "Welcome, $userInput!"
            } else {
                Toast.makeText(this, "Invalid credentials. Try again.", Toast.LENGTH_SHORT).show()
                username.setText("")
                password.setText("")
            }
        }
    }
}