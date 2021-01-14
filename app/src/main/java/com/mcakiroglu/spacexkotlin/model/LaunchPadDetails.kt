package com.mcakiroglu.spacexkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LaunchPadDetails {

    @SerializedName("location")
    @Expose
    val location: Location? = null

    @SerializedName("details")
    @Expose
    val details: String? = null

    @SerializedName("site_id")
    @Expose
    val siteId: String? = null
}