package com.astar.jsonplaceholderapp.data

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.domain.PostDomain

data class PostData(
    private val userId: Int,
    private val title: String,
    private val body: String
) : Abstract.Object<PostDomain, PostDataToDomainMapper>() {
    override fun map(mapper: PostDataToDomainMapper): PostDomain {
        return mapper.map(userId, title, body)
    }
}