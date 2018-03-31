package com.kotlin.aplaza.mvpkotlin

import com.kotlin.aplaza.mvpkotlin.domain.Command
import com.kotlin.aplaza.mvpkotlin.domain.ForecastList
import com.kotlin.aplaza.mvpkotlin.ui.MainPresenter
import com.kotlin.aplaza.mvpkotlin.ui.MainView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainPresenterTest {

    @Mock
    lateinit var view: MainView

    @Mock
    lateinit var command: Command<ForecastList>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkThatCommandIsCalled() {
        val presenter = MainPresenter(view)
        presenter.requestForecast(command)
        Mockito.verify(command).execute()
    }
}
