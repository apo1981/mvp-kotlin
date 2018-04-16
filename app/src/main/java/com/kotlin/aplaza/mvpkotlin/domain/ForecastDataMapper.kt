package com.kotlin.aplaza.mvpkotlin.domain

import com.kotlin.aplaza.mvpkotlin.data.Forecast
import com.kotlin.aplaza.mvpkotlin.data.ForecastResult
import java.util.*
import java.util.concurrent.TimeUnit
import com.kotlin.aplaza.mvpkotlin.domain.Forecast as ModelForecast

/**
 * Created by pla on 30/03/2018.
 */
class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult): ForecastList = ForecastList(
            zipCode, forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String =
            "http://openweathermap.org/img/w/$iconCode.png"
}