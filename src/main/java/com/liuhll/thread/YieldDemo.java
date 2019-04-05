package com.liuhll.thread;

public class YieldDemo {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    if (i == 5){
                        Thread.yield();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable,"A");
        Thread t2 = new Thread(runnable,"B");
        t1.start();
        t2.start();
    }
}
