package com.straydog.learnjava.multithreading;

import java.util.concurrent.Callable;

/**
 * Created by jyyc on 2017/5/9.
 */
public class MyCallable implements Callable<Integer> {

    /**
     * 与run方法不同的是 call()是具有返回值的
     */
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=0;i<=100;i++){
            System.out.println("当前线程的名称" + Thread.currentThread().getName() + " " + i);
            Thread.sleep(500);
            sum+=i;
        }
        return sum;

    }
}
