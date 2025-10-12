package com.recipebookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecipeAdapter
    private lateinit var editTitle: EditText
    private lateinit var editDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recipeRecyclerView)
        editTitle = findViewById(R.id.editTitle)
        editDescription = findViewById(R.id.editDescription)
        val btnAddSavory = findViewById<Button>(R.id.btnAddSavory)
        val btnAddSweet = findViewById<Button>(R.id.btnAddSweet)

        val items: MutableList<Any> = mutableListOf(
            Flavor.SAVORY,
            Flavor.SWEET
        )

        adapter = RecipeAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val swipeHandler = SwipeToDeleteCallback(adapter)
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        btnAddSavory.setOnClickListener { addRecipe(Flavor.SAVORY) }
        btnAddSweet.setOnClickListener { addRecipe(Flavor.SWEET) }
    }

    private fun addRecipe(flavor: Flavor) {
        val title = editTitle.text.toString().trim()
        val description = editDescription.text.toString().trim()

        if (title.isNotEmpty() && description.isNotEmpty()) {
            val recipe = Recipe(title, description, flavor)
            adapter.addRecipe(recipe)

            editTitle.text.clear()
            editDescription.text.clear()
        }
    }
}
