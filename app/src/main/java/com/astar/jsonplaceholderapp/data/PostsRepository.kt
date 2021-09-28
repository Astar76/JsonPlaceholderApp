package com.astar.jsonplaceholderapp.data

interface PostsRepository {

    suspend fun fetchPosts() : PostsData

    class Base(
        private val postsCloudDataSource: PostsCloudDataSource,
        private val postsCloudMapper: PostsCloudMapper
    ): PostsRepository {
        override suspend fun fetchPosts(): PostsData {
            return try {
                val postsCloudList = postsCloudDataSource.fetchPosts()
                val posts = postsCloudMapper.map(postsCloudList)
                PostsData.Success(posts)
            } catch (e: Exception) {
                PostsData.Error(e)
            }
        }
    }
}