package org.study.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class StrTest {

    @Test
    void testString() {
        String str = "hello";
        assertEquals("hello", str);
    }

}
