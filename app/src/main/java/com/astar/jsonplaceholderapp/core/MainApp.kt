package com.astar.jsonplaceholderapp.core

import android.app.Application
import com.astar.jsonplaceholderapp.data.PostsCloudDataSource
import com.astar.jsonplaceholderapp.data.PostsCloudMapper
import com.astar.jsonplaceholderapp.data.PostsRepository
import com.astar.jsonplaceholderapp.data.ToPostMapper
import com.astar.jsonplaceholderapp.domain.BasePostDataToDomainMapper
import com.astar.jsonplaceholderapp.domain.BasePostsDataToDomainMapper
import com.astar.jsonplaceholderapp.domain.PostsInteractor
import com.astar.jsonplaceholderapp.presentation.*
import com.google.gson.Gson

class MainApp: Application() {

    lateinit var mainViewModel : MainViewModel

    override fun onCreate() {
        super.onCreate()

        val gson = Gson()
        val service = NetworkApi.fetchApi()
        val cloudDataSource = PostsCloudDataSource.Base(service, gson)
        val toPostMapper = ToPostMapper.Base()
        val postsCloudMapper = PostsCloudMapper.Base(toPostMapper)
        val postsRepository = PostsRepository.Base(
            cloudDataSource,
            postsCloudMapper
        )
        val postsInteractor = PostsInteractor.Base(
            postsRepository,
            BasePostsDataToDomainMapper(BasePostDataToDomainMapper())
        )
        val communication = PostsCommunication.Base()
        mainViewModel = MainViewModel(
            postsInteractor,
            BasePostsDomainToUiMapper(
                ResourceProvider.Base(this),
                BasePostDomainToUiMapper()
            ),
            communication
        )
    }
}