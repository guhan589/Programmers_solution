package com.programmers.level1;

import java.util.*;

public class Stringarray_sort {
    /**
     *문자열 내 마음대로 정렬하기
     * **/

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        String[] result = solution(strings,n);
        for(String s:result)
            System.out.println(s);
    }
    public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        for(String str : strings)
            list.add(str);


        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {


                return o1.charAt(n) - o2.charAt(n) == 0 ? o1.compareTo(o2) : o1.charAt(n) - o2.charAt(n);
            }
        });

        answer = new String[list.size()];
        int count=0;

        for(String str :list){
            answer[count++] = str;
        }
        return answer;
    }
}
