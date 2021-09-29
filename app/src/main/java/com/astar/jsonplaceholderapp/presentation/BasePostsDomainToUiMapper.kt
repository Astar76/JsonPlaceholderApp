package com.astar.jsonplaceholderapp.presentation

import com.astar.jsonplaceholderapp.domain.ErrorType
import com.astar.jsonplaceholderapp.domain.PostDomain
import com.astar.jsonplaceholderapp.domain.PostDomainToUiMapper
import com.astar.jsonplaceholderapp.domain.PostsDomainToUiMapper

class BasePostsDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val postMapper: PostDomainToUiMapper
): PostsDomainToUiMapper{
    override fun map(posts: List<PostDomain>): PostsUi {
        return PostsUi.Success(posts, postMapper)
    }

    override fun map(errorType: ErrorType): PostsUi {
        return PostsUi.Error(errorType, resourceProvider)
    }
}