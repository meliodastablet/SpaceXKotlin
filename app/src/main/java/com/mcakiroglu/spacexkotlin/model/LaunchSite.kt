package com.mcakiroglu.spacexkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LaunchSite {

    @SerializedName("site_name")
    @Expose
    val siteName: String? = null

    @SerializedName("site_id")
    @Expose
    val siteId: String? = null



}