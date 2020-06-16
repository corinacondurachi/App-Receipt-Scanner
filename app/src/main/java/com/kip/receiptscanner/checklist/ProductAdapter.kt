package com.kip.receiptscanner.checklist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.kip.receiptscanner.Product
import com.kip.receiptscanner.R

class ProductAdapter(private val context: Context, private val products: ArrayList<Product>) :
    BaseAdapter() {
    // Creates a view to be used as a row in the list
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val rowMain = layoutInflater.inflate(R.layout.list_products, parent, false)

        // Add the name of the product to the row
        val tvName = rowMain.findViewById<TextView>(R.id.tv_name)
        tvName.text = products[position].name

        // Add the price of the product to the row
        val tvPrice = rowMain.findViewById<TextView>(R.id.tv_price)
        tvPrice.text = products[position].price.toString()

        return rowMain
    }

    // Returns an item to be placed in a given position from the products list
    override fun getItem(position: Int): Any {
        return products[position]
    }

    // This method defines a unique ID (we use the position of the item) for each row in the list
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Lets ListView know how many items has to display, returning size of the products list
    override fun getCount(): Int {
        return products.size
    }

}
