package com.lab41

import com.lab41.data.Item
import com.lab41.data.Loader
import org.junit.Assert.assertEquals
import org.junit.Test


class SynchronousLoader : Loader {
    override fun loadItems(count: Int, onItem: (Item) -> Unit, onComplete: () -> Unit) {
        for (i in 1..count) {
            onItem(Item("Item $i"))
        }
        onComplete()
    }
    override fun cancel() {}
}

class LoaderUnitTest {
    @Test
    fun `synchronous loader generates correct count`() {
        val loader = SynchronousLoader()
        val results = mutableListOf<Item>()
        var done = false
        loader.loadItems(3, { results.add(it) }, { done = true })
        assertEquals(3, results.size)
        assertEquals("Item 1", results[0].text)
        assertEquals(true, done)
    }
}