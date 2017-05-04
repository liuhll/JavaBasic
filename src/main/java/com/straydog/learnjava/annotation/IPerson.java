package com.straydog.learnjava.annotation;

/**
 * Created by liuhongliang on 2017/5/4.
 */
public interface IPerson {

    public String name();

    public int  criticalAge();

    @Deprecated
    public void sayHi();
}
