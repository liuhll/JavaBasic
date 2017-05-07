package com.straydog.learnjava.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Hongliang.Liu on 2017/5/7.
 */
public class ExceptionDemo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("请输入第一个数：");
            int one = scanner.nextInt();
            System.out.println("请输入第二个数：");
            int two = scanner.nextInt();

            System.out.println("两数相除为:" + one/two);
        }
        catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("您应当整数");
        }
        catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("除数不能为0");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("不知名异常" + e.getMessage());
        }
        finally {
            System.out.println("可以在这里放置一些善后语句");
        }
        System.out.println("程序结束了");
    }
}
