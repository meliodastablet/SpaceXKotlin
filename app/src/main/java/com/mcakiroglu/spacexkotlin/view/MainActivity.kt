package com.mcakiroglu.spacexkotlin.view

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcakiroglu.spacexkotlin.R
import com.mcakiroglu.spacexkotlin.adapter.LaunchListAdapter
import com.mcakiroglu.spacexkotlin.api.ApiClient
import com.mcakiroglu.spacexkotlin.api.RestInterface
import com.mcakiroglu.spacexkotlin.model.Launches
import com.mcakiroglu.spacexkotlin.utils.FormatUtil
import com.mcakiroglu.spacexkotlin.viewmodel.ApiViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var rest: RestInterface
    var launchesList: MutableList<Launches> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                recyclerView.adapter = ApiViewModel.searchLaunch(s.toString(),launchesList)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        rest = ApiClient.instance.getClient().create(RestInterface::class.java)
        var call: Call<MutableList<Launches>> = rest.getLaunches()
        call.enqueue(object : Callback<MutableList<Launches>> {
            override fun onResponse(
                    call: Call<MutableList<Launches>>,
                    response: Response<MutableList<Launches>>
            ) {
                if (FormatUtil.isNull(response.body())) {
                    launchesList = response.body()!!
                    var layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.layoutManager = layoutManager
                    var adapter = LaunchListAdapter(launchesList)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<MutableList<Launches>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
            }
        })


    }

}

