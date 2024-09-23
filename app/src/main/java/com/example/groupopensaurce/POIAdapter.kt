package com.example.groupopensaurce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class POI(val name: String, val imageResId: Int)

class POIAdapter(private val pois: List<POI>) : RecyclerView.Adapter<POIAdapter.POIViewHolder>() {

    // ViewHolder class
    class POIViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poiName: TextView = view.findViewById(R.id.poiNameTextView)
        val poiImage: ImageView = view.findViewById(R.id.poiImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): POIViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_poi, parent, false) // Correct layout name
        return POIViewHolder(view)
    }

    override fun onBindViewHolder(holder: POIViewHolder, position: Int) {
        val poi = pois[position]
        holder.poiName.text = poi.name
        holder.poiImage.setImageResource(poi.imageResId)
    }

    override fun getItemCount(): Int = pois.size
}
