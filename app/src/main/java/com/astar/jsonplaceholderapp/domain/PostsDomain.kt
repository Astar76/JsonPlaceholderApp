package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.data.PostData
import com.astar.jsonplaceholderapp.data.PostDataToDomainMapper
import com.astar.jsonplaceholderapp.presentation.PostsUi
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class PostsDomain : Abstract.Object<PostsUi, PostsDomainToUiMapper>() {
    class Success(
        private val posts: List<PostData>,
        private val postMapper: PostDataToDomainMapper
    ) : PostsDomain() {
        override fun map(mapper: PostsDomainToUiMapper): PostsUi {
            return mapper.map(posts.map {
                it.map(postMapper)
            })
        }
    }

    class Error(private val e: Exception) : PostsDomain() {
        override fun map(mapper: PostsDomainToUiMapper): PostsUi {
            return mapper.map(when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            })
        }
    }
}
