package com.lab41.robots

import com.lab41.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText

class Robot3 {
    fun assertDisplayedText(text: String): Robot3 {
        onView(withId(R.id.displayText)).check(matches(withText(text)))
        return this
    }
}