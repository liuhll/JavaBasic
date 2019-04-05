package com.liuhll.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FeatureTestDemo {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        Thread t = new Thread(task);
        t.start();
        if (!task.isDone()){
            System.out.println("task has no finished,please wait!");
        }
        try {
            System.out.println("task return:" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
