package com.astar.jsonplaceholderapp.data

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.domain.PostDomain

interface PostDataToDomainMapper: Abstract.Mapper {
    fun map(userId: Int, name: String, body: String): PostDomain
}