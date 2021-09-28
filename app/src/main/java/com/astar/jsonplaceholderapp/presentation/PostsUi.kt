package com.astar.jsonplaceholderapp.presentation

import com.astar.jsonplaceholderapp.R
import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.domain.ErrorType
import com.astar.jsonplaceholderapp.domain.PostDomain
import com.astar.jsonplaceholderapp.domain.PostDomainToUiMapper

sealed class PostsUi : Abstract.Object<Unit, PostsCommunication>() {

    class Success(
        private val posts: List<PostDomain>,
        private val postMapper: PostDomainToUiMapper
    ): PostsUi() {
        override fun map(mapper: PostsCommunication) {
            val postsUi = posts.map {
                it.map(postMapper)
            }
            mapper.map(postsUi)
        }
    }

    class Error(
        private val errorType: ErrorType,
        private val resourceProvider: ResourceProvider
    ): PostsUi() {
        override fun map(mapper: PostsCommunication) {
            val messageId = when(errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                else -> R.string.unknown_error
            }
            val message = resourceProvider.getString(messageId)
            mapper.map(listOf(PostUi.Error(message)))
        }
    }
}
