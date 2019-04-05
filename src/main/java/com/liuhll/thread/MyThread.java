package com.liuhll.thread;

public class MyThread extends Thread{
    private String name;

    public MyThread(String name){
        this.name =name;
        this.setName(name);
    }

    @Override
    public void run() {
        for (int i =0; i<=10; i++){
            System.out.println("Thread start:" + currentThread().getName() + ", i=" + i );
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
