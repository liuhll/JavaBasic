package com.straydog.liuhll.reflect.test;

import com.liuhll.reflect.Dog;
import org.junit.Test;

public class LoadDifferenceTest {

    @Test
    public void classForNameAndClassLoaderDiffTest() throws ClassNotFoundException {
        ClassLoader dogC = Dog.class.getClassLoader();

      //  Class docC2 = Class.forName("com.liuhll.reflect.Dog");
    }
}
