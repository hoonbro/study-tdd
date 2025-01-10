package org.example.junit;

import java.lang.reflect.Method;

public class JunitRunner {

    /*
     * runTests는 테스트 대상 클래스를 받아 인스턴스를 생성한다.
     * 테스트는 특정 객체에 의존적이지 않고, 어떤 클래스를 실행할지 인자로 받으면 되기 때문에 객체 생성 및 메서드 호출할 이유가 없을 듯
     *  -> 테스트 기능 자체가 클래스에 종속적이기 때문에 static 구현이 자연스럽다고 한다.
     */
    public static void runTests(Class<?> testClass) throws Exception {

        for(Method method : testClass.getDeclaredMethods()){
            Object testInstance = testClass.getDeclaredConstructor().newInstance();

            method.invoke(testInstance);
        }
    }
}
