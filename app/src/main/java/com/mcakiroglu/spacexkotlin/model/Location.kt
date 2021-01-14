package com.mcakiroglu.spacexkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("region")
    @Expose
    val region: String? = null

    @SerializedName("latitude")
    @Expose
    val latitude: Float? = null

    @SerializedName("longitude")
    @Expose
    val longitude: Float? = null

}