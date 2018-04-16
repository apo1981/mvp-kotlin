package com.kotlin.aplaza.mvpkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.aplaza.mvpkotlin.R
import com.kotlin.aplaza.mvpkotlin.domain.ForecastList
import com.kotlin.aplaza.mvpkotlin.domain.RequestForecastCommand
import com.kotlin.aplaza.mvpkotlin.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)
    private var forecastAdapter = ForecastListAdapter { toast(it.description) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        val request = RequestForecastCommand(29018)
        presenter.requestForecast(request)
    }

    private fun initRecyclerView() {
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = forecastAdapter
    }

    override fun showForecast(forecasts: ForecastList) {
        forecastAdapter.setData(forecasts)
        forecastAdapter.notifyDataSetChanged()
    }
}
