package com.straydog.learnjava.innerclass;

/**
 * @成员内部类
 */
public class OuterClass {

    private String name;
    private int age;

    public InnerClass getInnerClass(){
        return new InnerClass();
    }

    public void outDisplay(){
        System.out.println("outerClass...");
    }

    public class InnerClass{
        public InnerClass (){
            name = "张三";
            age =22;
        }

        public void display(){
            System.out.println("Display Method...");
        }

        public OuterClass getOuterClass(){
            return OuterClass.this;
        }
    }
}
