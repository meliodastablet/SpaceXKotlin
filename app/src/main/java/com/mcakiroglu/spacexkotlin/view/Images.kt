package com.mcakiroglu.spacexkotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcakiroglu.spacexkotlin.R
import com.mcakiroglu.spacexkotlin.adapter.ImageListAdapter
import kotlinx.android.synthetic.main.activity_images.*

class Images : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        val flick = intent.getStringArrayListExtra("flick")

        val layoutManager= LinearLayoutManager(baseContext)
        rview.setLayoutManager(layoutManager)
        var adapter: ImageListAdapter = ImageListAdapter(flick)
        rview.adapter = adapter



    }
}