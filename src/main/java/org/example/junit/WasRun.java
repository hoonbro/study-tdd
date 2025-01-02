package org.example.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WasRun {
    private String name;
    private boolean wasRun;

    public WasRun(String name){
        this.name = name;
    }

    public void testMethod(){
        this.wasRun = true;
    }

    public boolean getWasRun(){
        return wasRun;
    }

    public void run(){
        try{
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
