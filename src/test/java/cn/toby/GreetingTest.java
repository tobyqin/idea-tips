package cn.toby;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sayHello() {
        var g = new Greeting();
        var result = g.sayHello("toby");
        assertEquals("Hello, toby!", result);
    }
}