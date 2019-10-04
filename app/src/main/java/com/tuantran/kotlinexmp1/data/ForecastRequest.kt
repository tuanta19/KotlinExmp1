package com.tuantran.kotlinexmp1.data

import com.google.gson.Gson

class ForecastRequest(val zipCode: String){

    companion object {
        private val APP_ID="b6907d289e10d714a6e88b30761fae22"
        private val URL="http://api.openweathermap.org/data/2.5/" +
                 "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="

    }

    fun execute(): ForecastResult{
        val forecastJsonStr = java.net.URL(COMPLETE_URL+zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)

    }
}