package com.straydog.learnjava.innerclass;

/**
 * 成员内部内的测试类
 */
public class InnerClassTest1 {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        OuterClass.InnerClass innerClass1 = outerClass.new InnerClass();

        OuterClass.InnerClass innerClass2 = outerClass.getInnerClass();

        outerClass.outDisplay();
        innerClass1.display();
        innerClass2.display();
    }
}
