package com.lab41.ui

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.IdlingRegistry

import com.lab41.UITestApplication
import com.lab41.robots.Robot1
import com.lab41.robots.Robot2
import com.lab41.robots.Robot3

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITests {

    @get:Rule
    val activityRule = ActivityScenarioRule(Activity1::class.java)

    @Before
    fun setUp() {
        val app = ApplicationProvider.getApplicationContext<UITestApplication>()
        IdlingRegistry.getInstance().register(app.idling)
    }

    @After
    fun tearDown() {
        val app = ApplicationProvider.getApplicationContext<UITestApplication>()
        IdlingRegistry.getInstance().unregister(app.idling)
    }

    @Test
    fun flow_from1_to_3_shows_text() {
        Robot1()
            .enterNumber(3)
            .clickGo()

        Robot2()
            .assertItemCount(3)
            .clickItemAt(1)

        Robot3()
            .assertDisplayedText("Item 2")
    }
}
