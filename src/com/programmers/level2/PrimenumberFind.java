package com.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수 찾기 level 2 (미완성)
 * */
public class PrimenumberFind {

    static List<Integer> list = new ArrayList<>();
    static int[] number;
    public static void main(String[] args) {
        String numbers = "17";
        int result = solution(numbers);
        System.out.println("result-->" + result);
    }

    public static int solution(String numbers) {
        int answer = 0;
        int i = 0;
        char[] chnumber = String.valueOf(numbers).toCharArray();
        /*for (char c : chnumber) {
            System.out.println("c = " + c);
        }*/


        boolean b = modifyPrimenumber(70); // true: 소수o / false: 소수x

        System.out.println("b = " + b);


        return answer;
    }

    static List<Integer> makeNumber(char[] number) {

        return list;
    }
    static boolean modifyPrimenumber(int number){
        boolean result = false; //defalut = false
        int count = 0;
        double sqrt = Math.sqrt(number); //제곱근 까지 loop를 돌림
        for (int i = 1; i < sqrt; i++) {
            if (number % i == 0) {
                count++;
            }

            if(count>2)
                return false;
        }

        result = true;
//        else result = true;//소수
        return result;
    }

}
