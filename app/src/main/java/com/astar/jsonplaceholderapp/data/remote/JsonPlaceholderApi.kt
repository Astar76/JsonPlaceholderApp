package com.astar.jsonplaceholderapp.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("posts")
    suspend fun fetchPosts() : ResponseBody
}