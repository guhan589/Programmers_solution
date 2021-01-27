package com.programmers.level2;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

/**
 * 
 * 메뉴 리뉴얼(미완성)
 *
 *
 * **/
public class Menu {

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders2 = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] result = solution(orders2, course);
        for (String s : result) {
            System.out.println("result = " + s);
        }


    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        int min = course[0];
        HashMap<Character, Integer> map = putValue(orders);
        ArrayList<Character> deleteChList = new ArrayList<>(); //삭제할 문자 리스트
        ArrayList<String> addChList = new ArrayList<>(); //유효한 문자 리스트
        ArrayList<String> resultList = new ArrayList<>();//정상 문자 리스트
        
        for (Character ch : map.keySet()) {

//            System.out.println("ch + = " + ch + ", ch.get():" + map.get(ch));
            if(map.get(ch) > 1)
                addChList.add(String.valueOf(ch));
            else
                deleteChList.add(ch);
        }


        for (Character value : deleteChList)
            map.remove(value);


        for (int i = 0; i < orders.length; i++) {
            int time = 0;
            for (int j = 0; j < addChList.size(); j++) {
                if (orders[i].contains(addChList.get(j))) {
                    if (time >= min) {
                        resultList.add(orders[i]);
                        break;
                    }else
                        time++;
                }
            }

        }

        System.out.println("resultList.size() = " + resultList.size());
        answer = new String[resultList.size()];
        int i = 0;
        for (String s : resultList) {
            answer[i++] = s;
        }



        return answer;
    }
    static HashMap putValue(String[] orders){
        /**
         * HashMap에 데이터 값이 넣기(메뉴, 개수)
         * */
        HashMap<Character, Integer> map = new HashMap<>();

        for (String s : orders) {
            char[] ch = s.toCharArray();

            for (char c : ch) {
                int value = map.getOrDefault(c, 0);
                //값이 없을경우 defalut값을 받는다.
                map.put(c, ++value);

            }
        }

        return map;
    }

}


