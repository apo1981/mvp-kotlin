package com.kotlin.aplaza.mvpkotlin

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainPresenterTest {

    class MockUpMainView : MainView {
        var isShowForecastCalled = false
        override fun showForecast(forecastList: List<String>) {
            isShowForecastCalled = true

        }
    }

    @Test
    fun checkThatShowForecastIsCalledWhenForecastIsRequested() {
        val view = MockUpMainView()
        val presenter = MainPresenter(view)
        presenter.requestForecast()
        assertTrue(view.isShowForecastCalled)
    }
}
