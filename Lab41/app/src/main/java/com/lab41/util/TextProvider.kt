package com.lab41.util

import android.content.Context

class TextProvider(private val context: Context) {
    // Return UI text; tests can inject a mock context or override
    fun getEmptyText(): String = ""
    fun getGreeting(): String = "Selected:"
}