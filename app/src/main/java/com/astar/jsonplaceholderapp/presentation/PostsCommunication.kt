package com.astar.jsonplaceholderapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.astar.jsonplaceholderapp.core.Abstract

interface PostsCommunication : Abstract.Mapper {

    fun map(posts: List<PostUi>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<PostUi>>)

    class Base : PostsCommunication {
        private val listLiveData = MutableLiveData<List<PostUi>>()

        override fun map(posts: List<PostUi>) {
            listLiveData.value = posts
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<PostUi>>) {
            listLiveData.observe(owner, observer)
        }
    }
}