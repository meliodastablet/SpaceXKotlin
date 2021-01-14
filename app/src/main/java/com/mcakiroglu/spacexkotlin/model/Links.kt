package com.mcakiroglu.spacexkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("mission_patch")
    @Expose
    val missionPatch: String? = null

    @SerializedName("wikipedia")
    @Expose
    val wikipedia: String? = null

    @SerializedName("video_link")
    @Expose
    val videoLink: String? = null

    @SerializedName("flickr_images")
    @Expose
    val flickrImages: List<String>? = null
}