package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.data.PostData
import com.astar.jsonplaceholderapp.data.PostDataToDomainMapper
import com.astar.jsonplaceholderapp.data.PostsDataToDomainMapper
import java.lang.Exception

class BasePostsDataToDomainMapper(
    private val postMapper: PostDataToDomainMapper
) : PostsDataToDomainMapper {
    override fun map(posts: List<PostData>): PostsDomain {
        return PostsDomain.Success(posts, postMapper)
    }

    override fun map(e: Exception): PostsDomain {
        return PostsDomain.Error(e)
    }
}