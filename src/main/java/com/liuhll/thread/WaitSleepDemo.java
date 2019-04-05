package com.liuhll.thread;

public class WaitSleepDemo {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(){
            @Override
            public void run() {
                System.out.println("thread A is Waiting to get lock");

                synchronized (lock){
                    try {
                        System.out.println("Thread A get lock");
                        Thread.sleep(20);
                        System.out.println("Thread A do wait method");

                        //lock.wait(1000);
                        lock.wait();
                        System.out.println("Thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(){
            @Override
            public void run() {
                System.out.println("thread B is Waiting to get lock");

                synchronized (lock){
                    try {
                        System.out.println("Thread B get lock");
                        Thread.sleep(1000);
                        System.out.println("Thread B do wait method");

                        Thread.sleep(1000);

                        System.out.println("Thread B is done");
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }.start();
    }
}
