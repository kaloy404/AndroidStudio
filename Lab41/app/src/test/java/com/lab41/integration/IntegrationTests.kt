package com.lab41.integration

import android.content.Intent
import com.lab41.ui.Activity1
import com.lab41.ui.Activity2
import com.lab41.ui.Activity3
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class IntegrationTests {

    @Test
    fun `Activity1 passes count to Activity2`() {
        val intent = Intent().apply {
            putExtra(Activity2.EXTRA_COUNT, 10)
        }

        val controller = Robolectric.buildActivity(Activity2::class.java, intent).setup()
        val activity2 = controller.get()

        assertEquals(10, activity2.intent.getIntExtra(Activity2.EXTRA_COUNT, -1))
    }

    @Test
    fun `Activity2 passes item text to Activity3`() {
        val intent = Intent().apply {
            putExtra(Activity2.EXTRA_ITEM_TEXT, "Hello World")
        }

        val controller = Robolectric.buildActivity(Activity3::class.java, intent).setup()
        val activity3 = controller.get()

        assertEquals("Hello World", activity3.intent.getStringExtra(Activity2.EXTRA_ITEM_TEXT))
    }
}
