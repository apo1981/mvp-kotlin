package com.kotlin.aplaza.mvpkotlin

/**
 * Created by home on 24/03/18.
 */
class MainPresenter(private val view : MainView) {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8"
    )

    fun requestForecast() {
        view.showForecast(items)
    }
}