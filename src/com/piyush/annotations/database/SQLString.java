package com.piyush.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by eccspro on 28/03/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SQLString {
    int value() default 0;
    String name() default "";
    Constraints constrainsts() default @Constraints;
}
