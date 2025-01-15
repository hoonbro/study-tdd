package org.example.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// 어노테이션 정의
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeAll {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeEach {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterEach {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterAll {}

public class JunitRunner {

    private static final List<Method> beforeEachMethods = new ArrayList<>();
    private static final List<Method> afterEachMethods = new ArrayList<>();

    /*
     * runTests는 테스트 대상 클래스를 받아 인스턴스를 생성한다.
     * 테스트는 특정 객체에 의존적이지 않고, 어떤 클래스를 실행할지 인자로 받으면 되기 때문에 객체 생성 및 메서드 호출할 이유가 없을 듯
     *  -> 테스트 기능 자체가 클래스에 종속적이기 때문에 static 구현이 자연스럽다고 한다.
     */
    public static void runTests(Class<?> testClass) throws Exception {
        Method beforeAll = null;
        Method afterAll = null;

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
            if(method.isAnnotationPresent(Test.class)){
                runTest(testClass, method);
            }
        }

        invokeMethod(afterAll, null);
    }

    public static void runTest(Class<?> testClass, Method testMethod) throws Exception {
        Object instance = testClass.getDeclaredConstructor().newInstance();

        invokeMethods(beforeEachMethods, instance);
        invokeMethod(testMethod, instance);
        invokeMethods(afterEachMethods, instance);
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
