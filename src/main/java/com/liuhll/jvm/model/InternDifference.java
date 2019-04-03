package com.liuhll.jvm.model;

public class InternDifference {
    public static void main(String[] args) {

        String s1= new String("a");
        s1.intern();
        String s2 = "a";

        System.out.println(s1 == s2); //false



        String s4 = new String("a") + new String("a");
        s4.intern();
        String s5 = "aa";
        System.out.println(s4 == s5); // jdk6:false jdk6+: true
    }
}
