package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.presentation.PostUi

class PostDomain(
    private val userId: Int,
    private val title: String,
    private val body: String
): Abstract.Object<PostUi, PostDomainToUiMapper>() {
    override fun map(mapper: PostDomainToUiMapper): PostUi {
        return mapper.map(userId, title, body)
    }
}