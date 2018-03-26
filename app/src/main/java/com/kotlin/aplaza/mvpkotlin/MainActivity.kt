package com.kotlin.aplaza.mvpkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)
    private lateinit var forecastList : RecyclerView
    private var forecastAdapter = ForecastListAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList = findViewById(R.id.forecast_list)
        initRecyclerView()

        presenter.requestForecast()
    }

    private fun initRecyclerView() {
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = forecastAdapter
    }

    override fun showForecast(forecasts: List<String>) {
        forecastAdapter.setData(forecasts)
        forecastAdapter.notifyDataSetChanged()
    }
}
