package com.mcakiroglu.spacexkotlin.api

import com.mcakiroglu.spacexkotlin.model.LaunchDetails
import com.mcakiroglu.spacexkotlin.model.LaunchPadDetails
import com.mcakiroglu.spacexkotlin.model.Launches
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestInterface {

    companion object {
        val instance = this
    }

    @GET("launches/")
    fun getLaunches(): Call<MutableList<Launches>>

    @GET("launches/{flight_number}")
    fun getLaunchDetails(@Path(value = "flight_number", encoded = true) flight_number: String): Call<LaunchDetails>

    @GET("launchpads/{site_id}")
    fun getPadDetails(@Path(value = "site_id", encoded = true) site_id: String): Call<LaunchPadDetails>

}