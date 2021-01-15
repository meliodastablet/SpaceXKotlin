package com.mcakiroglu.spacexkotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mcakiroglu.spacexkotlin.R
import com.mcakiroglu.spacexkotlin.model.LaunchDetails
import com.mcakiroglu.spacexkotlin.model.Launches
import com.mcakiroglu.spacexkotlin.view.LaunchDeets

class ImageListAdapter(private val data: ArrayList<String>?): RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_layout2, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageListAdapter.ViewHolder, position: Int) {

        val list: String = data!!.get(position)
        Glide.with(holder.itemView.context).load(list).into(holder.iview)


    }

    override fun getItemCount(): Int {
        return data!!.size
    }

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
 val iview: ImageView= itemView.findViewById(R.id.imagew)

}


}