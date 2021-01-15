package com.mcakiroglu.spacexkotlin.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mcakiroglu.spacexkotlin.R
import com.mcakiroglu.spacexkotlin.api.ApiClient
import com.mcakiroglu.spacexkotlin.api.RestInterface
import com.mcakiroglu.spacexkotlin.model.LaunchDetails
import com.mcakiroglu.spacexkotlin.utils.FormatUtil
import kotlinx.android.synthetic.main.activity_launch_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class LaunchDeets : AppCompatActivity(), View.OnClickListener {
    val rest: RestInterface = ApiClient.instance.getClient().create(RestInterface::class.java)
    lateinit var myWebView: WebView
    lateinit var wikiUrl: String
    lateinit var youtubeUrl: String
    var flickrImages: List<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_details)
        myWebView = WebView(applicationContext)
        myWebView.settings.javaScriptEnabled = true
        wiki.setOnClickListener(this)
        yutup.setOnClickListener(this)
        images.setOnClickListener(this)


        val flightnum = intent.getStringExtra("flightnum")


        var call: Call<LaunchDetails> = rest.getLaunchDetails(flightnum!!)
        call.enqueue(object : Callback<LaunchDetails> {
            override fun onResponse(
                call: Call<LaunchDetails>,
                response: Response<LaunchDetails>
            ) {

                val launchDeetList: LaunchDetails = response.body()!!
                mname.setText(FormatUtil.isNullString(launchDeetList.missionName.toString()))
                lyear.setText(FormatUtil.isNullString(launchDeetList.launchYear.toString()))
                lsite.setText(FormatUtil.isNullString("Launch Site: " + launchDeetList.launchSite!!.siteName.toString()))
                rname.setText(FormatUtil.isNullString("Rocket Name: " + launchDeetList.rocket!!.rocketName.toString()))
                ldate.setText(FormatUtil.isNullString("Landing Date(UTC): " + launchDeetList.launchDateUtc.toString()))
                details.setText(FormatUtil.isNullString(launchDeetList.details.toString()))
                if(details.text == "")
                    details.setText("Details not found.")
                Glide.with(baseContext).load(launchDeetList.links!!.missionPatch).into(imageView)
                wikiUrl = launchDeetList.links.wikipedia.toString()
                youtubeUrl = launchDeetList.links.videoLink.toString()
                flickrImages = launchDeetList.links.flickrImages;
                if (flickrImages!!.isEmpty())
                    images.visibility = GONE


            }

            override fun onFailure(call: Call<LaunchDetails>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.wiki -> {
                    setContentView(myWebView)
                    myWebView.loadUrl(wikiUrl)

                }
                R.id.yutup -> {
                    setContentView(myWebView)
                    myWebView.loadUrl(youtubeUrl)
                }
                R.id.images -> {
                    val i = Intent(this, Images::class.java)
                    i.putStringArrayListExtra("flick", flickrImages as ArrayList<String>?)
                    startActivity(i)
                }
            }
        }
    }
}