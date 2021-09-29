package com.astar.jsonplaceholderapp.presentation

import com.astar.jsonplaceholderapp.R
import com.astar.jsonplaceholderapp.domain.ErrorType
import com.astar.jsonplaceholderapp.domain.PostDomain
import com.astar.jsonplaceholderapp.domain.PostDomainToUiMapper
import com.astar.jsonplaceholderapp.domain.PostsDomainToUiMapper

class BasePostsDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val postMapper: PostDomainToUiMapper
) : PostsDomainToUiMapper {
    override fun map(posts: List<PostDomain>): PostsUi {
        return PostsUi.Base(posts.map {
            it.map(postMapper)
        })
    }

    override fun map(errorType: ErrorType): PostsUi {
        val messageId = when(errorType) {
            ErrorType.NO_CONNECTION -> R.string.no_connection
            ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
            else -> R.string.unknown_error
        }
        val message = resourceProvider.getString(messageId)
        return PostsUi.Base(listOf(PostUi.Error(message)))
    }
}