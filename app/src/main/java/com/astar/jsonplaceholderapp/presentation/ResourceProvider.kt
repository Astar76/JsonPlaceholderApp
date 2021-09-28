package com.astar.jsonplaceholderapp.presentation

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes resId: Int) : String

    class Base(private val context: Context) : ResourceProvider {
        override fun getString(resId: Int): String {
            return context.getString(resId)
        }
    }
}