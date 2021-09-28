package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.presentation.PostsUi

interface PostsDomainToUiMapper: Abstract.Mapper {
    fun map(posts: List<PostDomain>): PostsUi
    fun map(errorType: ErrorType) : PostsUi
}