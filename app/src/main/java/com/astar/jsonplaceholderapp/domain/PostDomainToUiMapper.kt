package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.presentation.PostUi

interface PostDomainToUiMapper : Abstract.Mapper {
    fun map(userId: Int, title: String, body: String): PostUi
}
