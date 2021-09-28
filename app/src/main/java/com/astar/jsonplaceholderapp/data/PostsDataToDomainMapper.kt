package com.astar.jsonplaceholderapp.data

import com.astar.jsonplaceholderapp.core.Abstract
import com.astar.jsonplaceholderapp.domain.PostsDomain
import java.lang.Exception

interface PostsDataToDomainMapper : Abstract.Mapper {
    fun map(posts: List<PostData>): PostsDomain
    fun map(e: Exception): PostsDomain
}
