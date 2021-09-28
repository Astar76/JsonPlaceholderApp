package com.astar.jsonplaceholderapp.data

import com.astar.jsonplaceholderapp.data.remote.JsonPlaceholderApi
import com.astar.jsonplaceholderapp.data.remote.PostCloud
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface PostsCloudDataSource {

    suspend fun fetchPosts(): List<PostCloud>

    class Base(
        private val apiService: JsonPlaceholderApi,
        private val gson: Gson
    ) : PostsCloudDataSource {
        // todo make a wrapper
        private val type = object : TypeToken<List<PostCloud>>() {}.type

        override suspend fun fetchPosts(): List<PostCloud> {
            return gson.fromJson(apiService.fetchPosts().string(), type)
        }
    }
}