package com.piyush.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotationProcessor {

    public static void main(String args[]) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<AnnotatedTestClass> myAnnotatedClass = AnnotatedTestClass.class;

        // test @TestingInfo annotation
        if(myAnnotatedClass.isAnnotationPresent(TestingInfo.class)) {
            TestingInfo testingInfoAnnotation = myAnnotatedClass.getAnnotation(TestingInfo.class);

            System.out.println("created by : "  + testingInfoAnnotation.createdBy());
            System.out.println("priority : " + testingInfoAnnotation.priority());
            System.out.println("tags : " + testingInfoAnnotation.tags());

        }

        // test @Test annotation
        Method[] declaredMethods = myAnnotatedClass.getDeclaredMethods();
        for(Method method : declaredMethods) {
            if(method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                if(!annotation.ignore()) {
                    method.invoke(myAnnotatedClass.newInstance());
                }
                else{
                    System.out.println("Ignored method : " +  method.getName());
                }
            }
        }
    }
}
