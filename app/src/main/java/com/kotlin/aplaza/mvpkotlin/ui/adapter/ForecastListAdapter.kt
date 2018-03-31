package com.kotlin.aplaza.mvpkotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.aplaza.mvpkotlin.domain.ForecastList

/**
 * Created by home on 11/02/18.
 */
class ForecastListAdapter :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    private var weekForecast: ForecastList

    init {
        weekForecast = ForecastList("", "", listOf())
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast[position]) {
            holder?.textView?.text = "$date - $description - $high/$low"
        }
    }

    fun setData(data: ForecastList) {
        weekForecast = data
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}