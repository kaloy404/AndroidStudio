package com.recipebookapp

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private val items: MutableList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_FLAVOR = 0
        private const val TYPE_RECIPE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is Flavor) TYPE_FLAVOR else TYPE_RECIPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_FLAVOR) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_flavor_title, parent, false)
            FlavorViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recipe, parent, false)
            RecipeViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FlavorViewHolder) {
            holder.bind(items[position] as Flavor)
        } else if (holder is RecipeViewHolder) {
            holder.bind(items[position] as Recipe)
        }
    }

    override fun getItemCount() = items.size

    inner class FlavorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.textFlavorTitle)
        fun bind(flavor: Flavor) {
            title.text = flavor.name
        }
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.textRecipeTitle)
        fun bind(recipe: Recipe) {
            title.text = recipe.title

            itemView.setOnClickListener {
                AlertDialog.Builder(itemView.context)
                    .setTitle(recipe.title)
                    .setMessage(recipe.description)
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }

    fun addRecipe(recipe: Recipe) {
        val index = when (recipe.flavor) {
            Flavor.SAVORY -> items.indexOf(Flavor.SAVORY)
            Flavor.SWEET -> items.indexOf(Flavor.SWEET)
        }
        items.add(index + 1, recipe)
        notifyItemInserted(index + 1)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }
    fun getItemAt(position: Int): Any {
        return items[position]
    }
}
