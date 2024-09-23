package com.example.groupopensaurce

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Define the Hotel data class
data class Hotel(val name: String, val imageResId: Int)

class HotelsAdapter(private val hotelList: List<Hotel>, private val context: Context) :
    RecyclerView.Adapter<HotelsAdapter.HotelViewHolder>() {

    // Step 1: Create ViewHolder Class
    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hotelNameTextView: TextView = itemView.findViewById(R.id.hotelNameTextView)
        val hotelImageView: ImageView = itemView.findViewById(R.id.hotelImageView)
    }

    // Step 2: Inflate the item layout and return the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.viewholder_hotels, parent, false)
        return HotelViewHolder(view)
    }

    // Step 3: Bind data to the views inside the ViewHolder
    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel: Hotel = hotelList[position]
        holder.hotelNameTextView.text = hotel.name
        holder.hotelImageView.setImageResource(hotel.imageResId)
    }

    // Step 4: Return the number of items
    override fun getItemCount(): Int {
        return hotelList.size
    }
}
