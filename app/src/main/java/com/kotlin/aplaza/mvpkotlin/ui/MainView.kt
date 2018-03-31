package com.kotlin.aplaza.mvpkotlin.ui

import com.kotlin.aplaza.mvpkotlin.domain.ForecastList

/**
 * Created by home on 24/03/18.
 */
interface MainView {
    fun showForecast(forecastList: ForecastList)
}