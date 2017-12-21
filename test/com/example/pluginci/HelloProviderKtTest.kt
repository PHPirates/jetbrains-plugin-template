package com.example.pluginci

import org.junit.Assert.assertTrue
import org.junit.Test

open class HelloProviderKtTest {

    @Test
    fun `HelloProvider output test`() {
        assertTrue(HelloProvider.getHello() == "Hello Kotlin!")
    }
}