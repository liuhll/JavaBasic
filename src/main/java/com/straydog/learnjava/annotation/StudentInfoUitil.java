package com.straydog.learnjava.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Liuhongliang on 2017/5/4.
 * @functuon :注解处理器，通过反射获取注解的内容
 */
public class StudentInfoUitil {

    public static void getStudentInfo(Class<?> clazz){

       Method[] methods = clazz.getDeclaredMethods();

       for (Method method: methods){
           if(method.isAnnotationPresent(MyAnn.class)){
               MyAnn myAnn= (MyAnn) method.getAnnotation(MyAnn.class);
               String studentInfo="描述："+myAnn.desc()+" 年龄值："+myAnn.age()+"教师："+myAnn.teacher();
               System.out.println(studentInfo);
           }
       }

    }
}
