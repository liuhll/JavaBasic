package com.straydog.learnjava.annotation;

/**
 * Created by liuhongliang on 2017/5/4.
 */
public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        IPerson child = new Child();

        child.sayHi();

        IPerson student = new Student();

        StudentInfoUitil.getStudentInfo(student.getClass());

    }
}
