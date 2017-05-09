package com.straydog.learnjava.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by jyyc on 2017/5/9.
 */
public class MyCallableTest {

    public static void main(String[] args) {
        MyCallable callable = new MyCallable();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

        for (int i=0;i<=100;i++){
            System.out.println("当前线程的名称:" + Thread.currentThread().getName());

            if (i==5){
                Thread thread = new Thread(futureTask);
                thread.setName("futureTask" + i);
                thread.start();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("主线程for循环执行完毕..");

        try {
            int sum = futureTask.get();
            System.out.println("sum = "+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
