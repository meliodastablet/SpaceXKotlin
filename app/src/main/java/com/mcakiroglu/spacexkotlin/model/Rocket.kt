package com.mcakiroglu.spacexkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rocket {

    @SerializedName("rocket_name")
    @Expose
    var rocketName: String? = null
}