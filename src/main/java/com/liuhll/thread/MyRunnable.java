package com.liuhll.thread;

public class MyRunnable implements Runnable {

    public String name;

    public MyRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<=10; i++){
            System.out.println("Thread Strat:" + this.name + ",i=" + i);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
