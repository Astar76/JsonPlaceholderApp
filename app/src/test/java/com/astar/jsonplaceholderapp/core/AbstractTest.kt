package com.astar.jsonplaceholderapp.core

import org.junit.Assert.*
import org.junit.Test
import java.io.IOException

class AbstractTest {

    @Test
    fun test_success() {
        val dataObject = TestDataObject.Success("Text One", "Text Two")
        val domainObject = dataObject.map(DataMapper.Base())
        assertTrue(domainObject is DomainObject.Success)
    }

    @Test
    fun test_error() {
        val dataObject = TestDataObject.Error(IOException())
        val domainObject = dataObject.map(DataMapper.Base())
        assertTrue(domainObject is DomainObject.Error)
    }


    sealed class TestDataObject : Abstract.Object<DomainObject, DataMapper>() {

        abstract override fun map(mapper: DataMapper): DomainObject

        class Success(
            private val firstText: String,
            private val secondText: String
        ) : TestDataObject() {
            override fun map(mapper: DataMapper): DomainObject {
                return mapper.map(firstText, secondText)
            }
        }

        class Error(private val exception: Exception) : TestDataObject() {
            override fun map(mapper: DataMapper): DomainObject {
                return mapper.map(exception)
            }
        }
    }

    interface DataMapper : Abstract.Mapper {
        fun map(firstText: String, secondText: String): DomainObject
        fun map(exception: Exception): DomainObject

        class Base : DataMapper {
            override fun map(firstText: String, secondText: String): DomainObject {
                return DomainObject.Success("$firstText $secondText")
            }

            override fun map(exception: Exception): DomainObject {
                return DomainObject.Error()
            }
        }
    }

    sealed class DomainObject: Abstract.Object<UiObject, DomainToUiMapper>() {
        class Success(private val textCombined: String): DomainObject() {
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("Not yet implemented")
            }
        }

        class Error : DomainObject() {
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("Not yet implemented")
            }
        }
    }

    interface DomainToUiMapper: Abstract.Mapper

    sealed class UiObject: Abstract.Object<Unit, Abstract.Mapper.Empty>() {

    }
}