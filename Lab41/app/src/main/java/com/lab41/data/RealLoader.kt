package com.lab41.data

import java.util.*
import kotlin.concurrent.schedule

class RealLoader : Loader {
    private var timer: Timer? = null

    override fun loadItems(count: Int, onItem: (Item) -> Unit, onComplete: () -> Unit) {
        cancel()
        val t = Timer()
        timer = t
        for (i in 1..count) {
            t.schedule((i * 1000).toLong()) {
                onItem(Item("Item $i"))
                if (i == count) onComplete()
            }
        }
    }

    override fun cancel() {
        timer?.cancel()
        timer = null
    }
}