package com.kotlin.aplaza.mvpkotlin

import com.kotlin.aplaza.mvpkotlin.domain.Forecast
import com.kotlin.aplaza.mvpkotlin.domain.ForecastList
import com.kotlin.aplaza.mvpkotlin.ui.adapter.ForecastListAdapter
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ForecastListAdapterTest {

    private lateinit var sut : ForecastListAdapter

    @Before
    fun setUp() {
        sut = ForecastListAdapter { it.date }
    }

    @Test
    fun checkThatForecastItemsIsZeroWhenDataSourceIsEmpty() {
        val size = sut.itemCount
        assertEquals(0, size)
    }

    @Test
    fun checkThatForecastItemsIsEqualToDataSourceWhenIsNotEmpty() {
        val forecast1 = Forecast(20180319, "forecast1", 3,1,
                "https://url.com")
        val list = ForecastList(29018, "Malaga","Spain", listOf(forecast1, forecast1))
        sut.setData(list)
        val size = sut.itemCount
        assertEquals(list.size, size)
    }
}
