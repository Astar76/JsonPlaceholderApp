package com.astar.jsonplaceholderapp.data

import com.astar.jsonplaceholderapp.core.Abstract

interface ToPostMapper: Abstract.Mapper {

    fun map(userId: Int, title: String, body: String): PostData

    class Base : ToPostMapper {
        override fun map(userId: Int, title: String, body: String) = PostData(userId, title, body)
    }
}