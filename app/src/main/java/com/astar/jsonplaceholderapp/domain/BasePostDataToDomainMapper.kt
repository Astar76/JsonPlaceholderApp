package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.data.PostDataToDomainMapper

class BasePostDataToDomainMapper: PostDataToDomainMapper {
    override fun map(userId: Int, title: String, body: String): PostDomain {
        return PostDomain(userId, title, body)
    }
}