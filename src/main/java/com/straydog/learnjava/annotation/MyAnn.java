package com.straydog.learnjava.annotation;

import java.lang.annotation.*;

/**
 * Created by liuhongliang on 2017/5/4.
 */
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnn {

    String desc();

    String teacher();

    int age() default 18;

}

