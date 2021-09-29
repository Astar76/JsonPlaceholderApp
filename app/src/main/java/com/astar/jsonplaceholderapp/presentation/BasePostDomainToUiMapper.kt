package com.astar.jsonplaceholderapp.presentation

import com.astar.jsonplaceholderapp.domain.PostDomainToUiMapper

class BasePostDomainToUiMapper: PostDomainToUiMapper {
    override fun map(userId: Int, title: String, body: String): PostUi {
        return PostUi.Base(userId, title, body)
    }

}
