package com.astar.jsonplaceholderapp.presentation

import com.astar.jsonplaceholderapp.core.Abstract

sealed class PostUi : Abstract.Object<Unit, PostUi.StringMapper>() {
    override fun map(mapper: StringMapper) = Unit

    object Progress : PostUi()

    class Base(
        private val userId: Int,
        private val title: String,
        private val body: String
    ) : PostUi() {
        override fun map(mapper: StringMapper) {
            return mapper.map(title, body)
        }
    }

    class Error(
        private val message: String
    ) : PostUi() {
        override fun map(mapper: StringMapper) {
            return mapper.map("", message)
        }
    }

    interface StringMapper : Abstract.Mapper {
        fun map(title: String, body: String)
    }
}