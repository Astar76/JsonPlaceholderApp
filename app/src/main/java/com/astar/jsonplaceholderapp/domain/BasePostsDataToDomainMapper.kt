package com.astar.jsonplaceholderapp.domain

import com.astar.jsonplaceholderapp.data.PostData
import com.astar.jsonplaceholderapp.data.PostDataToDomainMapper
import com.astar.jsonplaceholderapp.data.PostsDataToDomainMapper
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

class BasePostsDataToDomainMapper(
    private val postMapper: PostDataToDomainMapper
) : PostsDataToDomainMapper {
    override fun map(posts: List<PostData>): PostsDomain {
        return PostsDomain.Success(posts, postMapper)
    }

    override fun map(e: Exception): PostsDomain {
        return PostsDomain.Error(when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        })
    }
}