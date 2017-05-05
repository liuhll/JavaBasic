package com.straydog.learnjava.reflection;

/**
 * Created by jyyc on 2017/5/5.
 */
public class ReflecionDemo2 {

    public static void main(String[] args) {

        Class<Employee> eClazz = Employee.class;
        System.out.println(eClazz.getName());

        Class<?> clazz = Employee.class;
        System.out.println(clazz.getName());

        Class clazz2 = Employee.class;
        System.out.println(clazz2.getName());

    }

}
