package com.example.groupopensaurce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var restaurantAdapter: RestaurantAdapter
    private lateinit var poiAdapter: POIAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Step 1: Find the RecyclerView for hotels in the layout
        val recyclerViewHotels: RecyclerView = findViewById(R.id.recyclerViewhotels)

        // Step 2: Set a layout manager for hotels (Horizontal)
        recyclerViewHotels.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Step 3: Provide a list of hotels (sample data)
        val hotels = listOf(
            Hotel("Hotel A", R.drawable.h1),
            Hotel("Gold Reef City Hotel", R.drawable.h2),
            Hotel("Hotel C", R.drawable.h1),
            Hotel("Hotel D", R.drawable.h1),
            Hotel("Hotel E", R.drawable.h2),
            Hotel("Hotel F", R.drawable.h1)
        )

        // Step 4: Create and set the adapter for hotels
        val hotelAdapter = HotelsAdapter(hotels, this)
        recyclerViewHotels.adapter = hotelAdapter

        // Step 5: Find the RecyclerView for restaurants in the layout
        val recyclerViewRestaurants = findViewById<RecyclerView>(R.id.recyclerViewresturant)

        // Step 6: Set a layout manager for restaurants (Horizontal)
        recyclerViewRestaurants.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Step 7: Provide a list of restaurants (sample data)
        val restaurants = getRestaurantList()

        // Step 8: Create and set the adapter for restaurants
        restaurantAdapter = RestaurantAdapter(restaurants)
        recyclerViewRestaurants.adapter = restaurantAdapter

        // Initialize RecyclerView for POIs (remains vertical by default)
        val recyclerViewPOI = findViewById<RecyclerView>(R.id.recyclerViewPOI)
        recyclerViewPOI.layoutManager = LinearLayoutManager(this)
        val pois = getPOIList()
        poiAdapter = POIAdapter(pois)
        recyclerViewPOI.adapter = poiAdapter
    }

    private fun getRestaurantList(): List<Restaurant> {
        // Provide sample data for restaurants
        return listOf(
            Restaurant("Restaurant A", R.drawable.r3),
            Restaurant("Restaurant B", R.drawable.r4),
            Restaurant("Restaurant C", R.drawable.r5),
            Restaurant("Restaurant D", R.drawable.r3),
            Restaurant("Restaurant E", R.drawable.r4),
            Restaurant("Restaurant F", R.drawable.r5)
        )
    }

    private fun getPOIList(): List<POI> {
        // Provide sample data for points of interest
        return listOf(
            POI("Restaurant A", R.drawable.r3),
            POI("Restaurant B", R.drawable.r4),
            POI("Hotel A", R.drawable.h1),
            POI("Restaurant D", R.drawable.r3),
            POI("Gold Reef City Hotel", R.drawable.h2),
            POI("Restaurant D", R.drawable.r3),
            POI("Hotel C", R.drawable.h1)
        )
    }
}
