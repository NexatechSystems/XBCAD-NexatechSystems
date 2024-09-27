package com.example.groupopensaurce

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Hotel(val name: String, val imageResId: Int)

class HotelsAdapter(private val hotelList: List<Hotel>, private val context: Context) :
    RecyclerView.Adapter<HotelsAdapter.HotelViewHolder>() {

    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hotelNameTextView: TextView = itemView.findViewById(R.id.hotelNameTextView)
        val hotelImageView: ImageView = itemView.findViewById(R.id.hotelImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.viewholder_hotels, parent, false)
        return HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel: Hotel = hotelList[position]
        holder.hotelNameTextView.text = hotel.name
        holder.hotelImageView.setImageResource(hotel.imageResId)

        // Set onClickListener to navigate to BookingActivity when a hotel is clicked
        holder.itemView.setOnClickListener {
            val intent = Intent(context, HotelBookingActivity::class.java)
            intent.putExtra("HOTEL_NAME", hotel.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotelList.size
    }
}
