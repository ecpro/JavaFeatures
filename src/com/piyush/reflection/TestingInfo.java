package com.piyush.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestingInfo {
    public enum Priority {
        HIGH, LOW, MEDIUM
    }
    public Priority priority() default Priority.LOW;
    public String createdBy() default "";
    public String[] tags() default {};
    public String lastModified();
}
