package com.learning.productservice;

import com.learning.productservice.controllers.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RandomTest {
    // a test case is nothing but a method annotated with @Test
    // a test case fails if any of the assertion in the test case fails

    @Autowired
    private ProductController productController;

    @Test
    void testOnePlusOneIsTwo(){
        int i= 1+ 1;

        assert i == 2;

        assertTrue(i == 2);
//        assertEquals(i, 2);
//        assertNotEquals(i,5);
//        assertNotNull(i);
//        assertNotNull();
//        assertInstanceOf(i, Integer.class);
    }

}
