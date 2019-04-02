package com.liuhll.reflect.classloader;

import com.liuhll.reflect.Dog;

import java.lang.reflect.Method;

public class ClassLoaderBootStrap {

    public static void main(String[] args) throws Exception{
        MyClassLoader myClassLoader = new MyClassLoader("C:\\Users\\LiuHongliang\\Desktop\\workspaces\\java-basic\\target\\classes\\com\\liuhll\\reflect\\","MyClassLoader");
        Class c = myClassLoader.loadClass("Dog");
        System.out.println(c.getClassLoader());

        Dog dog = (Dog) c.newInstance();
        Method barkMethod = c.getMethod("bark");
        barkMethod.invoke(dog);

    }

}
