package com.kotlin.aplaza.mvpkotlin.data.db

import com.kotlin.aplaza.mvpkotlin.domain.ForecastList
import com.kotlin.aplaza.mvpkotlin.ui.utils.clear
import com.kotlin.aplaza.mvpkotlin.ui.utils.parseList
import com.kotlin.aplaza.mvpkotlin.ui.utils.parseOpt
import com.kotlin.aplaza.mvpkotlin.ui.utils.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by pla on 15/04/2018.
 */
class ForecastDb(private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 private val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? " +
                "AND ${DayForecastTable.DATE} >= ?"

        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList{ DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("$(CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt{ CityForecast(HashMap(it), dailyForecast)}

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }
}