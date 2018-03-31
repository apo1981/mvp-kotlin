package com.kotlin.aplaza.mvpkotlin.domain

import com.kotlin.aplaza.mvpkotlin.data.ForecastRequest

/**
 * Created by pla on 30/03/2018.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}