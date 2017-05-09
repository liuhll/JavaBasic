package com.straydog.learnjava.multithreading;

/**
 * Created by jyyc on 2017/5/9.
 */
public class MyThreadTest {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.setName("MyThread1");

        MyThread myThread2 = new MyThread();
        myThread2.setName("MyThread2");
        myThread2.start();
//        try {
//            myThread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        myThread1.start();
    }
}
