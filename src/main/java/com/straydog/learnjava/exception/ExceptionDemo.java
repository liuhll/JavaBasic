package com.straydog.learnjava.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Hongliang.Liu on 2017/5/7.
 */
public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            System.out.println("请输入您的年龄:");
            Scanner input = new Scanner(System.in);

            int age = input.nextInt();

            System.out.println("十年后您的年龄为:" + (age + 10));
        }catch (InputMismatchException e){
            System.out.println("您应当输入整数");
            //throw e;
        }
        System.out.println("程序结束啦");

    }
}
