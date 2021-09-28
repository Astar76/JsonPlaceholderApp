package com.astar.jsonplaceholderapp.data

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.domain.PostsDomain

sealed class PostsData : Abstract.Object<PostsDomain, PostsDataToDomainMapper>() {
    data class Success(private val posts: List<PostData>) : PostsData() {
        override fun map(mapper: PostsDataToDomainMapper): PostsDomain {
            return mapper.map(posts)
        }
    }

    data class Error(private val e: Exception) : PostsData() {
        override fun map(mapper: PostsDataToDomainMapper): PostsDomain {
            return mapper.map(e)
        }
    }
}