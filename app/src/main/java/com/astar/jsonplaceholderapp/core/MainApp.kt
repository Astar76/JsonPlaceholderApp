package com.astar.jsonplaceholderapp.core

import android.app.Application
import com.google.gson.Gson

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val gson = Gson()
    }
}