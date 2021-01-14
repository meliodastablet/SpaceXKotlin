package com.mcakiroglu.spacexkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LaunchDetails {
    @SerializedName("mission_name")
    @Expose
    val missionName: String? = null

    @SerializedName("launch_year")
    @Expose
    val launchYear: String? = null

    @SerializedName("flight_number")
    @Expose
    val flightNumber: Int? = null


    @SerializedName("launch_date_utc")
    @Expose
    val launchDateUtc: String? = null

    @SerializedName("details")
    @Expose
    val details: Any? = null


    @SerializedName("links")
    @Expose
    val links: Links? = null

    @SerializedName("launch_site")
    @Expose
    val launchSite: LaunchSite? = null

    @SerializedName("rocket")
    @Expose
    val rocket: Rocket? = null
}