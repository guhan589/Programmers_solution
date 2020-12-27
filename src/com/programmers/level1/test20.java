package com.programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/***
 * 문자열 내 마듬대로 정렬하기(Level 1)
 *
 */

public class test20 {

    public static void main(String[] args){
        String[] str = {"sun", "bed", "car"};
        int n =1;
        String[] result = Solution(str, n);
    }
    public static String[] Solution(String[] strings, int n){
        Map<Integer, Character> map = new HashMap<>();

        for(int i = 0 ; i < strings.length; i++){
            char c = strings[i].charAt(n);
            map.put(i,c); // [0,u]
        }
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            char c = (char) iterator.next();
            System.out.println(c);
        }


        return new String[0];
    }
}
