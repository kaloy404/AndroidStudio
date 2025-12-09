package com.lab41.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab41.util.App
import com.lab41.R
import com.lab41.data.Item
import com.lab41.data.Loader

class Activity2 : AppCompatActivity() {
    companion object {
        const val EXTRA_COUNT = "extra_count"
        const val EXTRA_ITEM_TEXT = "extra_item_text"
    }

    private lateinit var loader: Loader
    private lateinit var adapter: SimpleAdapter
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        loader = (application as App).provideLoader()

        progress = findViewById(R.id.progress)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        adapter = SimpleAdapter { item ->
            val intent = Intent(this, Activity3::class.java)
            intent.putExtra(EXTRA_ITEM_TEXT, item.text)
            startActivity(intent)
        }
        recycler.adapter = adapter

        val count = intent?.getIntExtra(EXTRA_COUNT, 0) ?: 0
        progress.visibility = View.VISIBLE
        loader.loadItems(count, onItem = {
            runOnUiThread {
                adapter.addItem(it)
            }
        }, onComplete = {
            runOnUiThread { progress.visibility = View.GONE }
        })
    }

    override fun onDestroy() {
        loader.cancel()
        super.onDestroy()
    }
}