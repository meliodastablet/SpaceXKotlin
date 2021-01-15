package com.mcakiroglu.spacexkotlin.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mcakiroglu.spacexkotlin.adapter.LaunchListAdapter
import com.mcakiroglu.spacexkotlin.model.Launches
import kotlinx.android.synthetic.main.activity_main.*

class ApiViewModel: ViewModel() {

    companion object{
        fun searchLaunch(name: String, launchList: List<Launches>): LaunchListAdapter{

            var searchList: MutableList<Launches> = mutableListOf()
            for (launch in launchList){
                if(name in launch.missionName!!.toLowerCase()){
                    searchList.add(launch)
                }
            }
            var adapter = LaunchListAdapter(searchList)

            return adapter

        }
    }



}