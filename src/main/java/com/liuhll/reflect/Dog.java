package com.liuhll.reflect;

public class Dog {


    static {
        System.out.println("Hello Dog");
    }
    private String name;

    public void bark(){
        System.out.println(name + ":汪汪汪");
    }
}
