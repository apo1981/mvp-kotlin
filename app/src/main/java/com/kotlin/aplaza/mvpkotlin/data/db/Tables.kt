package com.kotlin.aplaza.mvpkotlin.data.db

/**
 * Created by pla on 14/04/2018.
 */
object CityForecastTable {
    const val NAME = "CityForecast"
    const val ID = "_id"
    const val CITY = "city"
    const val COUNTRY = "country"
}

object DayForecastTable {
    const val NAME = "DayForecast"
    const val ID = "_id"
    const val DATE = "date"
    const val DESCRIPTION = "description"
    const val HIGH = "high"
    const val LOW = "low"
    const val ICON_URL = "iconUrl"
    const val CITY_ID = "cityId"
}