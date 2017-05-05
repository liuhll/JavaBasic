package com.straydog.learnjava.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyyc on 2017/5/5.
 */
public class Box<T> {

    private T data;

    public Box(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }


}
