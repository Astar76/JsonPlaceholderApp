package com.astar.jsonplaceholderapp.presentation

import com.astar.jsonplaceholderapp.core.Abstract

sealed class PostsUi : Abstract.Object<Unit, PostsCommunication>() {

    data class Base(private val posts: List<PostUi>): PostsUi() {
        override fun map(mapper: PostsCommunication) {
            return mapper.map(posts)
        }
    }
}
