package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.presentation.PostUi

sealed class PostDomain : Abstract.Object<PostUi, PostDomainToUiMapper>() {
    data class Base(
        private val userId: Int,
        private val title: String,
        private val body: String
    ) : PostDomain() {
        override fun map(mapper: PostDomainToUiMapper): PostUi {
            return mapper.map(userId, title, body)
        }
    }
}