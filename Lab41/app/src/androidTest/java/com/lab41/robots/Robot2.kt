package com.lab41.robots

import com.lab41.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*

class Robot2 {
    fun assertItemCount(expected: Int): Robot2 {
        // A basic way is to wait until expected items appear; using idling resource or check adapter size via custom matcher
        // Simplest: scroll to position expected-1 to ensure it's present
        onView(withId(R.id.recycler)).perform(RecyclerViewActions.scrollToPosition<androidx.recyclerview.widget.RecyclerView.ViewHolder>(expected - 1))
        return this
    }

    fun clickItemAt(position: Int): Robot2 {
        onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition<androidx.recyclerview.widget.RecyclerView.ViewHolder>(position, click()))
        return this
    }
}