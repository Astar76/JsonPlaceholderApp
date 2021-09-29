package com.astar.jsonplaceholderapp.presentation

import androidx.lifecycle.*
import com.astar.jsonplaceholderapp.domain.PostsDomainToUiMapper
import com.astar.jsonplaceholderapp.domain.PostsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val postsInteractor: PostsInteractor,
    private val mapper: PostsDomainToUiMapper,
    private val communication: PostsCommunication
): ViewModel() {

    fun fetchPosts() {
        communication.map(listOf(PostUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = postsInteractor.fetchPosts()
            val resultUi = resultDomain.map(mapper)
            withContext(Dispatchers.Main) {
                resultUi.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<PostUi>>) {
        communication.observe(owner, observer)
    }
}
