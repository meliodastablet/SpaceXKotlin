package com.mcakiroglu.spacexkotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.mcakiroglu.spacexkotlin.R
import com.mcakiroglu.spacexkotlin.model.Launches

class LaunchListAdapter(private val data: MutableList<Launches>): RecyclerView.Adapter<LaunchListAdapter.ViewHolder>(), View.OnClickListener {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LaunchListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchListAdapter.ViewHolder, position: Int) {
        var launches: Launches = data.get(position)
        holder.tvName.setText(launches.missionName)
        holder.tvName2.setText(launches.launchYear)
        holder.cl.setOnClickListener(this)



    }

    override fun getItemCount(): Int {
        return data.size
    }

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvName: TextView = itemView.findViewById(R.id.textView)
    var tvName2: TextView = itemView.findViewById(R.id.textView2)
    var cl: ConstraintLayout = itemView.findViewById(R.id.constLayout)

}

    override fun onClick(v: View?) {
        var tvName: TextView = v!!.findViewById(R.id.textView)
        if(v.id == R.id.constLayout){
            for (item in data){
                if(item.missionName!!.toLowerCase().contains(tvName.text.toString())){
                   //TODO
                }
            }
        }

    }


}