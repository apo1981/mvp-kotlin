package com.kotlin.aplaza.mvpkotlin.ui

import com.kotlin.aplaza.mvpkotlin.domain.Command
import com.kotlin.aplaza.mvpkotlin.domain.ForecastList
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by home on 24/03/18.
 */
class MainPresenter(private val view : MainView) {

    fun requestForecast(command: Command<ForecastList>) {
        doAsync {
            val forecast = command.execute()
            uiThread { view.showForecast(forecast) }
        }
    }
}