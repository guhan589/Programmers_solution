package com.programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 소수 찾기 level 2 (미완성)
 * */
public class PrimenumberFind {

    static List<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static int[] number;
    public static void main(String[] args) {
//        String numbers = "17";
        String numbers = "011";
        int result = solution(numbers);
        System.out.println("result-->" + result);
    }

    public static int solution(String numbers) {
        int answer = 0;
        char[] chnumber = String.valueOf(numbers).toCharArray();
        boolean[] bo = new boolean[numbers.length()];

        Set<Integer> integers = makeNumber(chnumber);
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
        for (int integer : integers) {
            if (modifyPrimenumber(integer)) {
                list.add(integer);
            }
        }
        for (Integer integer : list) {
            System.out.println("result = " + integer);
        }


//        System.out.println("list.size() = " + list.size());
        return list.size();

    }
    static Set<Integer> makeNumber(char[] number) {
        for (int i = 0; i < number.length; i++) {
            set.add(Integer.parseInt(String.valueOf(number[i])));
            String temp = String.valueOf(number[i]);
            for (int j = 0; j < number.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    temp += number[j];
                    set.add(Integer.parseInt(String.valueOf(number[i])+String.valueOf(number[j])));
                    set.add(Integer.parseInt(String.valueOf(temp)));
                }
            }
        }
        return set;
    }
    static boolean modifyPrimenumber(int number){
        boolean result = false; //defalut = false
        int count = 0;
        double sqrt = Math.sqrt(number); //제곱근 까지 loop를 돌림
        System.out.println("sqrt = " + sqrt);
        if (number == 1 || number == 0)
            return false;

        if(number==2||number==3)
            return true;
        for (int i = 1; i < sqrt; i++) {
            if (number % i == 0)
                ++count;

            if(count>=2)
                return false;
        }

        result = true;
//        else result = true;//소수
        return result;
    }

}
