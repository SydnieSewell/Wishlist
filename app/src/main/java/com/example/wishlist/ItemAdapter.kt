package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.Item

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the view within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO 1 : Create member variables for any view that will be set
        // as you render a row.

        var itemNameTextView: TextView
        var itemPriceTextView: TextView
        var itemUrlTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO 2: Store each of the layout's views into
            // the public final member variables created above

            itemNameTextView = itemView.findViewById(R.id.itemNameTv)
            itemPriceTextView = itemView.findViewById(R.id.itemPriceTv)
            itemUrlTextView = itemView.findViewById(R.id.itemUrlTv)

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.items_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.itemNameTextView.text = item.itemName
        holder.itemPriceTextView.text = item.itemPrice
        holder.itemUrlTextView.text = item.itemUrl

    }

    override fun getItemCount(): Int {
        return items.size
    }
}