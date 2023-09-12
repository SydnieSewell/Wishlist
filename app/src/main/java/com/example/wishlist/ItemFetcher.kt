package com.example.wishlist



class ItemFetcher {
    companion object {
        var itemName = listOf("Black Jeans", "Gold Heels", "Pandora Bracelet")
        var itemUrl = listOf("plt.com", "plt.com", "pandora.com")
        var itemPrice = listOf("19.99", "15.99", "65.00")
        fun getItems(): MutableList<Item> {
            var items: MutableList<Item> = ArrayList()
            for (i in 0..itemName.size - 1) {
                val item = Item(itemName[i], itemUrl[i], itemPrice[i])
                items.add(item)
            }
            return items
        }
    }
}