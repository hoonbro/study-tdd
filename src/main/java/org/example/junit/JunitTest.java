package org.example.junit;

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
    @AfterEach
    public void tearDown(){
        System.out.println("After each Test");
    }
    @AfterAll
    public static void tearDownAll(){
        System.out.println("After All Test");
    }

}
