package com.astar.jsonplaceholderapp.core

import com.astar.jsonplaceholderapp.data.remote.JsonPlaceholderApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkApi {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun fetchApi() = build().create(JsonPlaceholderApi::class.java)

    private fun build() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}