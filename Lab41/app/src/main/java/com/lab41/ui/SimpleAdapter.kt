package com.lab41.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab41.R
import com.lab41.data.Item

class SimpleAdapter(private val onClick: (Item) -> Unit)
    : RecyclerView.Adapter<SimpleAdapter.VH>() {

    private val items = mutableListOf<Item>()

    fun addItem(i: Item) {
        items.add(i)
        notifyItemInserted(items.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return VH(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.text.text = item.text
        holder.itemView.setOnClickListener { onClick(item) }  // WORKING
    }

    class VH(view: View) : RecyclerView.ViewHolder(view) {   // FIXED
        val text: TextView = view.findViewById(R.id.itemText)
    }
}
