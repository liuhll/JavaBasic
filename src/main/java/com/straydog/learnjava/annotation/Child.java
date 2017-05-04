package com.straydog.learnjava.annotation;

/**
 * Created by liuhongliang on 2017/5/4.
 */
public class Child implements IPerson {

    @Override
    public String name() {
        return "小孩";
    }


    @Override
    public int criticalAge() {
        return 16;
    }


    @Override
    public void sayHi() {
        System.out.println("Child　Say:Hello World");
    }
}
