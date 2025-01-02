package org.example.junit;

public class JunitTest {

    public static void main(String[] args) {
        WasRun test = new WasRun("testMethod");

        System.out.println("testMethod = " + test.getWasRun());
        test.run();
        System.out.println("testMethod = " + test.getWasRun());
    }
}
