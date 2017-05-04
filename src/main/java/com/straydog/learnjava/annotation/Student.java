package com.straydog.learnjava.annotation;

/**
 * Created by jyyc on 2017/5/4.
 */
public class Student implements IPerson {
    @Override
    @MyAnn(desc = "我是高中生",teacher = "张三")
    public String name() {
        return "学生";
    }

    @Override
    public int criticalAge() {
        return 18;
    }

    @Override
    public void sayHi() {
        System.out.println("Student Say Hi");
    }
}
