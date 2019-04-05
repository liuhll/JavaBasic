package com.liuhll.thread;

public class MyRunnableBootstrap {

    public static void main(String[] args) {
        MyRunnable runnable1 = new MyRunnable("MyRunnable1");
        MyRunnable runnable2 = new MyRunnable("MyRunnable2");
        MyRunnable runnable3 = new MyRunnable("MyRunnable3");

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);
        t1.start();
        t2.start();
        t3.start();
    }

}
