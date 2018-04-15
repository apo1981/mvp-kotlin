package com.kotlin.aplaza.mvpkotlin.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.kotlin.aplaza.mvpkotlin.App
import org.jetbrains.anko.db.*

/**
 * Created by pla on 14/04/2018.
 */
class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)
        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER, DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }

    companion object {
        const val DB_NAME = "forecast.db"
        const val DB_VERSION = 1
        val instance by lazy { ForecastDbHelper() }
    }
}