package com.straydog.learnjava.multithreading;

/**
 * Created by jyyc on 2017/5/9.
 */
public class MyRuanbleTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunable());

        thread1.setName("MyRunable1");

        Thread thread2 = new Thread(new MyRunable());
        thread2.setName("MyRunable2");



        /**
         * 使用匿名内部类来实现Runnable
         */
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名:" + Thread.currentThread().getName());
            }
        });
        thread3.setName("Runable3");

        //设置优先级
//        thread1.setPriority(Thread.MIN_PRIORITY);
//        thread2.setPriority(Thread.NORM_PRIORITY);
//        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
