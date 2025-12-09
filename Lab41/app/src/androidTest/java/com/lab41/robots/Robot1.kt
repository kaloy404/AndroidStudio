package com.lab41.robots

import com.lab41.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*

class Robot1 {
    fun enterNumber(n: Int): Robot1 {
        onView(withId(R.id.numberEdit)).perform(replaceText(n.toString()), closeSoftKeyboard())
        return this
    }
    fun clickGo(): Robot1 {
        onView(withId(R.id.goButton)).perform(click())
        return this
    }
}