package com.kotlin.aplaza.mvpkotlin

import android.app.Application
import com.kotlin.aplaza.mvpkotlin.ui.utils.DelegatesExt

/**
 * Created by pla on 14/04/2018.
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}