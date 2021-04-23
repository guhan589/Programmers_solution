package com.programmers.level2;

import java.util.*;

public class Menu2 {
    public static void main(String[] args) {
        String[] orders1= {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders2 = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] result = solution(orders1, course);
        for (String s : result) {
            System.out.println("result = " + s);
        }
    }

    public static String[] solution(String[] orders, int[] coures) {
        String[] answer = {};

        List list = new ArrayList(Arrays.asList(orders));

        Collections.sort(list, new Comparator<String>() { //문자열 길이를 오름차순으로 정렬
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        /*for (Object o : list) {
            System.out.println("o = " + o);
        }*/


        for (int index = 0; index < list.size()-1; index++) {
            String temp = String.valueOf(list.get(index));
            for (int i = 0; i < temp.length(); i++) {

            }

        }

        return answer;
    }

    static void dfs(String orders) {

    }
}
