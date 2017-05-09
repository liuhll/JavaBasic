package com.straydog.learnjava.multithreading;

/**
 * Created by jyyc on 2017/5/9.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread Name:" + getName());
    }
}
