package com.mcakiroglu.spacexkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Launches {

    @SerializedName("mission_name")
    @Expose
    val missionName: String? = null

    @SerializedName("launch_year")
    @Expose
    val launchYear: String? = null

    @SerializedName("flight_number")
    @Expose
    val flightNumber: Int? = null
}