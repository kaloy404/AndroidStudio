package com.lab41.data

interface Loader {

    /**
     * Load count items asynchronously. Callback for each produced item.
     * Provide a means to cancel if needed.
     */
    fun loadItems(
        count: Int,
        onItem: (Item) -> Unit,
        onComplete: () -> Unit
    )

    fun cancel()
}
