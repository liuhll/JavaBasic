package com.straydog.learnjava.innerclass;

/**
 * @function: 匿名内部类的Demo
 */
public class OuterClass2 {

    //匿名内部类,没有构造方法，直接实现接口
    public IFlyable bird = new IFlyable() {
        @Override
        public void fly() {
            System.out.println("鸟儿能飞...");
        }
    };
}
