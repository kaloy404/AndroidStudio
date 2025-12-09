package com.lab41

import android.content.Context
import com.lab41.util.TextProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock

class TextProviderTest {
    private val context: Context = mock()

    @Test
    fun `getEmptyText returns empty string`() {
        val provider = TextProvider(context)
        assertEquals("", provider.getEmptyText())
    }

    @Test
    fun `getGreeting returns non empty greeting`() {
        val provider = TextProvider(context)
        assert(provider.getGreeting().isNotEmpty())
    }
}