package com.astar.jsonplaceholderapp.data

import com.astar.jsonplaceholderapp.core.Abstract

interface PostsCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<Abstract.Object<PostData, ToPostMapper>>): List<PostData>

    class Base(private val mapper: ToPostMapper) : PostsCloudMapper {
        override fun map(cloudList: List<Abstract.Object<PostData, ToPostMapper>>): List<PostData> {
            return cloudList.map { bookCloud ->
                bookCloud.map(mapper)
            }
        }
    }
}
