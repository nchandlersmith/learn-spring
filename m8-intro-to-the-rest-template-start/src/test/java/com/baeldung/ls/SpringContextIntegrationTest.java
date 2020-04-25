package com.baeldung.ls;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORTp)
public class SpringContextIntegrationTest {

    @Test
    public void whenContextIsLoaded_thenNoExceptions() {
    }
}