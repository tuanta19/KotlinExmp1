package com.tuantran.kotlinexmp1.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.tuantran.kotlinexmp1.ui.adapters.ForecastListAdapter
import com.tuantran.kotlinexmp1.R
import com.tuantran.kotlinexmp1.data.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(){

    private val items= listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList:RecyclerView=findViewById(R.id.forecast_list)
        forecastList.layoutManager=LinearLayoutManager(this)
        forecastList.adapter= ForecastListAdapter(items)

        val url="https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b6907d289e10d714a6e88b30761fae22"

        doAsync{
            Request(url).run()
            uiThread { longToast("Request performed") }

        }


    }


    fun niceToast(message: String,
                  tag: String= MainActivity::class.java.simpleName,
                  length: Int=Toast.LENGTH_LONG){
        Toast.makeText(this, "$tag $message", length).show()
    }

}
