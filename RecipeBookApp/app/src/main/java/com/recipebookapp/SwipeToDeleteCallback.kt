package com.recipebookapp

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeToDeleteCallback(private val adapter: RecipeAdapter) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ) = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.bindingAdapterPosition
        val item = adapter.getItemAt(position)

        // ✅ Prevent deleting header items (Flavor titles)
        if (item is Recipe) {
            adapter.removeItem(position)
        } else {
            // If header was swiped, just reset its position
            adapter.notifyItemChanged(position)
        }
    }
}
