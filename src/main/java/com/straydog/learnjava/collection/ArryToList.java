package com.straydog.learnjava.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jyyc on 2017/5/3.
 */
public class ArryToList {

    public static void main(String[] args) {
        String[] lines = new String[]{"Abc","BCD","DFG"};

        List<String> lineList = Arrays.asList(lines);

        System.out.println(lineList);

    }
}
