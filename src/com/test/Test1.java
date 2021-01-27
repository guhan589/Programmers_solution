package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String[] str = {"AB", "AB", "BC", "DF"};
        List<String> list = new ArrayList<String>();
        for (String s : str) {
            list.add(s);
        }

        list.stream().distinct().forEach(s -> System.out.println(s));
        /*Arrays.stream(str).distinct();
        Arrays.stream(str).distinct();
        Arrays.stream(str).forEach(s -> System.out.println(s));*/

    }
}
