package com.kotlin.aplaza.mvpkotlin

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
        sut = ForecastListAdapter(listOf())
    }

    @Test
    fun checkThatForecastItemsIsZeroWhenDataSourceIsEmpty() {
        val size = sut.itemCount
        assertEquals(0, size)
    }

    @Test
    fun checkThatForecastItemsIsEqualToDataSourceWhenIsNotEmpty() {
        val list = listOf("hola", "Adios")
        sut.setData(list)
        val size = sut.itemCount
        assertEquals(list.size, size)
    }
}
