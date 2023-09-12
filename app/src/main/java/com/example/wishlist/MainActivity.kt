package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.app.Activity


class MainActivity : AppCompatActivity() {
    lateinit var items: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Lookup the RecyclerView in activity layout
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
//        // Fetch the list of items
        items = ItemFetcher.getItems()
        var currentSize=items.size
        // Create adapter passing in the list of items
        val adapter = ItemAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter
        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this)

        val submitButton = findViewById<Button>(R.id.submitButtonBt)
        submitButton.setOnClickListener {


//            Step 1: Need to initialize variables
            //New item name
            var newItemName: String
            //New Item Price
            var newItemPrice: String
            // New Item Url
            var newItemUrl: String

            //Assign the EditText values to the respective variables
            var newItemNameInput: TextView = findViewById(R.id.itemNameIV)
            newItemName = newItemNameInput.text.toString()
            var newItemUrlInput: TextView = findViewById(R.id.itemUrLIV)
            newItemUrl = newItemUrlInput.text.toString()
            var newItemPriceInput: TextView = findViewById(R.id.itemPriceIV)
            newItemPrice = newItemPriceInput.text.toString()


            //To add a new item to the list
            (items as MutableList<Item>).add(Item(newItemName, newItemUrl, newItemPrice))
            //Increase the current size of list
            currentSize += 1
            adapter.notifyItemInserted(currentSize-1)



            // Reset input fields to all user to re-enter
            newItemNameInput.text = ""
            newItemPriceInput.text = ""
            newItemUrlInput.text = ""



//            fun hideKeyboard(view: TextView) {
////                if (view != null) {
////                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
////                    imm.hideSoftInputFromWindow(view.windowToken, 0)
////                }
             //To close keyboard.
            val view = currentFocus
            if (view != null) {
                view.clearFocus()
                val inputMethodManager =
                    getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(
                    view.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }
        }
    }
}