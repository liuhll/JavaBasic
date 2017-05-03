package com.straydog.learnjava.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 集合与数组的遍历方式
 * 1. for
 * 2. iterator
 * 3. foreach
 */
public class IterateList {


    public static void main(String[] args) {

        String[] strArr = createArray();

        List<String> strList = Arrays.asList(strArr);

        // for遍历
        long start;
        long end;
        String tempStr ="";

        start = System.currentTimeMillis();

        //使用for遍历
        for (int i = 0;i<strList.size();i++){
            tempStr = strList.get(i);
        }
        end = System.currentTimeMillis();

        System.out.println("for use time:" + (end - start));

        //使用iterator遍历
        start = System.currentTimeMillis();
        for(Iterator<String> iterator = strList.iterator(); iterator.hasNext();){
            tempStr = iterator.next();
        }
        end = System.currentTimeMillis();

        System.out.println("iterator use time:" + (end - start));

        start = System.currentTimeMillis();
        for (String str: strList) {

            tempStr = str;
        }
        end = System.currentTimeMillis();

        System.out.println("foreach use time:" + (end - start));
    }


    private static String[] createArray(){
        String[] strArray = new String[15000000];
        for (int i = 0 ; i<15000000;i++){
            strArray[i] = "Array" + i;
        }
        return strArray;
    }
}
