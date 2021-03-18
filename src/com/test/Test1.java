package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String[] str = {"AB", "AB", "BC", "DF"};
        String[] str1 = {"AB", "BC"};
        List<String> list = new ArrayList<String>(Arrays.asList(str));
        List<String> list1 = new ArrayList<String>(Arrays.asList(str1));



    }
}
