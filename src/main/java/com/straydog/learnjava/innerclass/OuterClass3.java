package com.straydog.learnjava.innerclass;

/**
 * Created by jyyc on 2017/5/9.
 */
public class OuterClass3 {

    private String sex;
    static String name = "chenssy";

    /**
     *静态内部类
     */
    static class InnerClass1{
        /* 在静态内部类中可以存在静态成员 */
        static String _name1 = "chenssy_static";

        void display(){
                /*
                 * 静态内部类只能访问外围类的静态成员变量和方法
                 * 不能访问外围类的非静态成员变量和方法
                 */
            System.out.println("OutClass name :" + name);

            //编译不通过
            //System.out.println(OuterClass3.this);
        }
    }

    /**
     * 非静态内部类
     */
    public class InnerClass2{
        /* 非静态内部类中不能存在静态成员 */
        public String _name2 = "chenssy_inner";
        /* 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的 */
        public void display(){
            System.out.println("OuterClass name：" + name);
        }
    }

    /**
     * @desc 外围类方法
     * @author chenssy
     * @data 2013-10-25
     * @return void
     */
    public void display(){
            /* 外围类访问静态内部类：内部类. */
        System.out.println(InnerClass1._name1);
            /* 静态内部类 可以直接创建实例不需要依赖于外围类 */
        new InnerClass1().display();

            /* 非静态内部的创建需要依赖于外围类 */
        OuterClass3.InnerClass2 inner2 = new OuterClass3().new InnerClass2();
            /* 方位非静态内部类的成员需要使用非静态内部类的实例  */
        System.out.println(inner2._name2);
        inner2.display();
    }

    public static void main(String[] args) {
        OuterClass3 outerClass = new OuterClass3();
        outerClass.display();

        OuterClass3.InnerClass1 innerClass1 = new InnerClass1();
        innerClass1.display();
    }

}
