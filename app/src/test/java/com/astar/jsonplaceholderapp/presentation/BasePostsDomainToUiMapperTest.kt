package com.astar.jsonplaceholderapp.presentation

import com.astar.jsonplaceholderapp.R
import com.astar.jsonplaceholderapp.domain.ErrorType
import com.astar.jsonplaceholderapp.domain.PostDomainToUiMapper
import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalStateException

class BasePostsDomainToUiMapperTest {

    @Test
    fun test_error() {
        val resourceProvider = TestResourceProvider()
        val mapper = BasePostsDomainToUiMapper(resourceProvider, object : PostDomainToUiMapper {
            override fun map(userId: Int, title: String, body: String): PostUi {
                throw IllegalStateException("not used here")
            }
        })
        var actual = mapper.map(ErrorType.NO_CONNECTION)
        var expected = PostsUi.Base(listOf(PostUi.Error("noConnection")))
        assertEquals(expected, actual)
        actual = mapper.map(ErrorType.SERVICE_UNAVAILABLE)
        expected = PostsUi.Base(listOf(PostUi.Error("serviceUnavailable")))
        assertEquals(expected, actual)
        actual = mapper.map(ErrorType.GENERIC_ERROR)
        expected = PostsUi.Base(listOf(PostUi.Error("UnknownError")))
        assertEquals(expected, actual)
    }

    private inner class TestResourceProvider: ResourceProvider {
        override fun getString(resId: Int): String {
            return when(resId) {
                R.string.no_connection -> "noConnection"
                R.string.service_unavailable -> "serviceUnavailable"
                else -> "UnknownError"
            }
        }
    }
}