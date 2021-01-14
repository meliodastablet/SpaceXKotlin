package com.mcakiroglu.spacexkotlin.api

import com.mcakiroglu.spacexkotlin.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        val instance = ApiClient()
    }


    private var retrofit: Retrofit? = null;

    fun getClient(): Retrofit {
            if(retrofit == null){
                retrofit = Retrofit.Builder().baseUrl(Constants.baseUrl).addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient()).build()
            }

        return retrofit as Retrofit;

    }
}