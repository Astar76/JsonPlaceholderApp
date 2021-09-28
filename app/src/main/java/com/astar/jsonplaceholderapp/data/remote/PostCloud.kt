package com.astar.jsonplaceholderapp.data.remote

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.data.PostData
import com.astar.jsonplaceholderapp.data.ToPostMapper
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostCloud(
    @SerializedName("userId")
    @Expose
    val userId: Int,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("body")
    @Expose
    val body: String
) : Abstract.Object<PostData, ToPostMapper>() {
    override fun map(mapper: ToPostMapper) = mapper.map(userId, title, body)
}