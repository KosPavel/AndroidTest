package com.kospavel.androidtest

import android.app.Application
import android.content.Context
import com.kospavel.androidtest.di.AppComponent
import com.kospavel.androidtest.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    init {
        initGraph()
    }

    private fun initGraph() {
        appComponent = DaggerAppComponent.builder().build()
    }

    companion object {
        fun get(context: Context): App =
            context.applicationContext as App
    }

}