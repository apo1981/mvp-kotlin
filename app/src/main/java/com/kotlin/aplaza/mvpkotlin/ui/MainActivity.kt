package com.kotlin.aplaza.mvpkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.aplaza.mvpkotlin.R
import com.kotlin.aplaza.mvpkotlin.domain.ForecastList
import com.kotlin.aplaza.mvpkotlin.domain.RequestForecastCommand
import com.kotlin.aplaza.mvpkotlin.ui.adapter.ForecastListAdapter
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)
    private lateinit var forecastList : RecyclerView
    private var forecastAdapter = ForecastListAdapter { toast(it.date) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList = findViewById(R.id.forecast_list)
        initRecyclerView()

        val request = RequestForecastCommand("29018")
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
