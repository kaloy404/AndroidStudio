package com.lab41

import androidx.test.espresso.idling.CountingIdlingResource
import com.lab41.data.Item
import com.lab41.data.Loader
import com.lab41.util.App

class UITestApplication : App() {

    val idling = CountingIdlingResource("Loader")

    override fun provideLoader(): Loader {
        return object : Loader {
            override fun loadItems(count: Int, onItem: (Item) -> Unit, onComplete: () -> Unit) {

                // Tell Espresso that a background task is running
                idling.increment()

                for (i in 1..count) {
                    onItem(Item("Item $i"))
                }

                // Task done
                onComplete()
                idling.decrement()
            }

            override fun cancel() {}
        }
    }
}
