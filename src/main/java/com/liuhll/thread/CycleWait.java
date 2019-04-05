package com.liuhll.thread;

public class CycleWait implements Runnable {

    private String value;


    @Override
    public void run() {

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have values";
    }

    public static void main(String[] args) {
        CycleWait cw = new CycleWait();
        Thread t1 = new Thread(cw);
        t1.start();
        System.out.println("value " + cw.value);
// 1. 主线程等待法
//        while (cw.value == null){
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

// 2. 使用join()阻塞法，等待子线程完成
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cw.value);
    }
}
