package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.data.PostsDataToDomainMapper
import com.astar.jsonplaceholderapp.data.PostsRepository

interface PostsInteractor {

    suspend fun fetchPosts() : PostsDomain

    class Base(
        private val postsRepository: PostsRepository,
        private val mapper: PostsDataToDomainMapper
    ): PostsInteractor {
        override suspend fun fetchPosts(): PostsDomain {
            return postsRepository.fetchPosts().map(mapper)
        }
    }
}