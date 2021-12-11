package com.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class NumberAndEnglish {
    public static void main(String[] args) {
        String s = "one4seveneight";
        int solution = solution(s);
        System.out.println("solution = " + solution);

    }
    public static int solution(String s) {
        int answer = 0 ;
        Map<String, Integer> map = setMap();
        try{
            answer = Integer.parseInt(s);
            return answer;
        }catch (NumberFormatException e){//문자값이 있음 즉 순수한 숫자로 구성되어있지 않음
            for (String s1 : map.keySet()) {
                int number = map.get(s1);
                s= s.replaceAll(s1,String.valueOf(number));
            }

            answer = Integer.parseInt(s);
        }
        return answer;
    }
    public static Map<String, Integer> setMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        map.put("zero",0);


        return map;

    }
}
