package com.straydog.learnjava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by jyyc on 2017/5/5.
 */
public class ReflectionDemo {

    public static void main(String[] args) {


        try {
            //获取类类型的机制

            //1. 通过Class.forName("类的完全限定名")
            //
            Class eClass1 = Class.forName("com.straydog.learnjava.reflection.Employee");
            System.out.println("通过Class.forName(\"类的完全限定名\"):" + eClass1.toString());

            // 2. 通过类的属性 java中每个类型都有class 属性
            Class eClass2 = Employee.class;
            System.out.println("通过类的class获取到:" + eClass2);

            // 3. 通过对象的 getClass() 方法
            Employee e = new Employee();
            Class eClass3 = e.getClass();
            System.out.println("通过对象的getClass()方法:" + eClass3);


            // 创建对象 利用newInstance方法

            // 1.调用无参数的构造器
            Employee e2 = (Employee) eClass1.newInstance();
            System.out.println(e2.toString());

            //2. 调用有参数的构造器
            Constructor eContructor = eClass1.getConstructor(String.class,int.class,String.class);
            Employee e3 = (Employee) eContructor.newInstance("张三",33,"技术部");
            System.out.println(e3.toString());

            // 获取属性以及属性的值
            Field[] fields = eClass1.getDeclaredFields();
            for (Field field:fields){
                System.out.println("获取到的属性名称名为:" + field.getName());

                System.out.println("属性的修饰符:" + Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等
                System.out.println("属性的类型的名字:" + field.getType().getSimpleName() + " ");//属性的类型的名字
            }

            //动态调用方法
            //1. 获取方法
//            1.1，getDeclaredMethods能拿到所有（不包括继承的方法）；
//            1.2，getMethods只能拿到public方法（包括继承的类或接口的方法）

            //无参数
            Method doWork = eClass1.getDeclaredMethod("work");
            doWork.invoke(e3);

            Method speak = eClass1.getDeclaredMethod("speak",String.class);
            speak.invoke(e3,"我要继续工作");

            Method getName = eClass1.getMethod("getName");
            String eName = (String) getName.invoke(e3);
            System.out.println("获取员工姓名为:" + eName);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
