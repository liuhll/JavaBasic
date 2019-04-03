package com.liuhll.jvm.gc;

public class ReferenceCounterProblem {

    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();

        // 循环引用
        obj1.childNode = obj2;
        obj2.childNode = obj1;
    }
}
