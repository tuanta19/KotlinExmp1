package com.tuantran.kotlinexmp1.domain

import com.tuantran.kotlinexmp1.data.ForecastResult
import java.util.*
import java.util.concurrent.TimeUnit

class ForecastDataMapper{

    fun convertFromDataModel(forecast: ForecastResult): ForecastList{
        return ForecastList(forecast.city.name, forecast.city.country, conver )
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>{
        return list.mapIndexed(i, forecast ->
        val dt=Calendar.getInstance().timeInMillis+TimeUnit.DAYS.toMillis(i.toLong()))
        convertForecastListToDomain(forecast.copy(dt=dt))
    }
}