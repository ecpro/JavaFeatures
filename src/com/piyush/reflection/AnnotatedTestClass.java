package com.piyush.reflection;

@TestingInfo(createdBy = "Piyush", priority = TestingInfo.Priority.HIGH, lastModified = "23/03/2018")
public class AnnotatedTestClass {

    @Test
    public void test1() {
        System.out.println("test1 executed successfully");
    }

    @Test(ignore = true)
    public void test2() {
        System.out.println("test2 executed successfully");
    }
}
