package com.example.pluginci;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class HelloProviderTest {

    @Test
    public void testOutput() {
        // The .INSTANCE is because we're calling Kotlin from Java
        assertTrue(HelloProvider.INSTANCE.getHello().equals("Hello Kotlin!"));
    }
}
