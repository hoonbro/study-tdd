package org.example.junit;

import org.example.junit.common.annotation.*;

public class JunitTest {

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Before All Test");
    }
    @BeforeEach
    public void setUp(){
        System.out.println("Before each Test");
    }
    @Test
    public void simpleTest(){
        System.out.println("Execute Test");
    }

    @Test
    public void failedTest(){
        System.out.println("Failed Test");

        throw new RuntimeException();
    }
    @AfterEach
    public void tearDown(){
        System.out.println("After each Test");
    }
    @AfterAll
    public static void tearDownAll(){
        System.out.println("After All Test");
    }

}
