package com.straydog.learnjava.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyyc on 2017/5/5.
 */
public class GenericTest {

    public static void main(String[] args) {
        Box<String> boxStr = new Box<String>("This ia  data");

        System.out.println(boxStr.getData());
        System.out.println(boxStr.getClass().getName());
        System.out.println();
        Box<Integer> boxInt = new Box<Integer>(100);
        System.out.println(boxInt.getData());
        System.out.println(boxInt.getClass().getName());

        // 在使用泛型类时，虽然传入了不同的泛型实参，
        // 但并没有真正意义上生成不同的类型，传入不同泛型实参的泛型类在内存上只有一个，即还是原来的最基本的类型（本实例中为Box）
        // 当然，在逻辑上我们可以理解成多个不同的泛型类型
        System.out.println(boxInt.getClass().getName().equals(boxStr.getClass().getName()));


        showClass(100);
        showClass(200L);
        showClass(199.00F);

        // 编译出错
        // showClass("sdsd");

    }

    public static  <T extends Number> void showClass(T t){
        System.out.println(t.getClass().getName());
    }
}
