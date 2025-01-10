package org.example.junit;

public class Calculator {
    private int a = 2;
    private int b = 1;
    public void addition(){
        System.out.println(a + " + " + b + " = " + (a+b));
    }

    public void subtract(){
        System.out.println(a + " - " + b + " = " + (a+b));
    }

    public void multiple(){
        System.out.println(a + " * " + b + " = " + (a+b));
    }

    public void division(){
        if(b == 0)
            throw new IllegalArgumentException("cannot divide by zero");

        System.out.println(a + " / " + b + " = " + (a+b));
    }
}
