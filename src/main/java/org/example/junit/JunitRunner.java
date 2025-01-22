package org.example.junit;

import org.example.junit.common.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JunitRunner {



    public static void runTests(Class<?> testClass) throws Exception {
        runTests(testClass, null);
    }

    /*
     * runTests는 테스트 대상 클래스를 받아 인스턴스를 생성한다.
     * 테스트는 특정 객체에 의존적이지 않고, 어떤 클래스를 실행할지 인자로 받으면 되기 때문에 객체 생성 및 메서드 호출할 이유가 없을 듯
     *  -> 테스트 기능 자체가 클래스에 종속적이기 때문에 static 구현이 자연스럽다고 한다.
     */
    public static void runTests(Class<?> testClass, String nameFilter) throws Exception {
        TestResult testResult = new TestResult();
        Method beforeAll = null;
        Method afterAll = null;
        List<Method> beforeEachMethods = new ArrayList<>();
        List<Method> afterEachMethods = new ArrayList<>();

        for(Method method : testClass.getDeclaredMethods()){
            if(method.isAnnotationPresent(BeforeAll.class)){
               beforeAll = method;
            }else if (method.isAnnotationPresent(BeforeEach.class)){
                beforeEachMethods.add(method);
            }else if (method.isAnnotationPresent(AfterAll.class)){
                afterAll = method;
            }else if (method.isAnnotationPresent(AfterEach.class)){
                afterEachMethods.add(method);
            }
        }

        invokeMethod(beforeAll, null);

        for(Method method : testClass.getDeclaredMethods()){
            if(method.isAnnotationPresent(Test.class) && (method.getName().equals(nameFilter) || nameFilter == null)){
                testResult.incrementTotalCnt();
                try{
                    runTest(testClass, method, beforeEachMethods, afterEachMethods);
                    testResult.incrementPassedCnt();
                }catch (Exception e){
                    testResult.incrementFailedCnt();
                    testResult.addFailedDetails("Test : " + method.getName() + " failed : " + e.getCause());
                }
            }
        }

        invokeMethod(afterAll, null);

        testResult.printDetails();
    }

    /**
     *  메서드 성공/실패 여부에 관계없이 BeforeEach, AfterEach 가 각각 실행되어야 하기 때문에 finally 추가
     */
    public static void runTest(Class<?> testClass, Method testMethod, List<Method> beforeEachMethods, List<Method> afterEachMethods) throws Exception {
        Object instance = testClass.getDeclaredConstructor().newInstance();

        try {
            invokeMethods(beforeEachMethods, instance);
            invokeMethod(testMethod, instance);
        }finally {
            invokeMethods(afterEachMethods, instance);
        }
    }

    private static void invokeMethod(Method method, Object instance) throws Exception {
        if(method != null)
            method.invoke(instance);
    }
    private static void invokeMethods(List<Method> methods, Object instance) throws Exception {
        for(Method method : methods){
            method.invoke(instance);
        }
    }
}
