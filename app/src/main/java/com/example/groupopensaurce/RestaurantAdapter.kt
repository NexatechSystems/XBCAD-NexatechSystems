package com.example.groupopensaurce

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Context

data class Restaurant(val name: String, val imageResId: Int)

class RestaurantAdapter(
    private val restaurants: List<Restaurant>,
    private val context: Context // Pass context to launch activities
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    // ViewHolder class
    class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restaurantName: TextView = view.findViewById(R.id.restaurantNameTextView)
        val restaurantImage: ImageView = view.findViewById(R.id.restaurantImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.restaurantName.text = restaurant.name
        holder.restaurantImage.setImageResource(restaurant.imageResId)

        // Set an item click listener
        holder.itemView.setOnClickListener {
            // Create an Intent to navigate to RestaurantBookingActivity
            val intent = Intent(context, ResBookingActivity::class.java)
            intent.putExtra("RESTAURANT_NAME", restaurant.name) // Pass restaurant name to the booking activity
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = restaurants.size
}
