package com.programmers.level2;


import java.util.HashSet;


/**
 * 소수찾기 level2 미완성 
 * 
 * */
//17 => 7 17 71
public class FindMinority {
    public static void main(String[] args) {
        String numbers = "17";
        int result = solution(numbers);
        System.out.println("result = " + result);
    }

    public static int solution(String numbers) {
        int count = 0;

        return count;
    }
    /*public static int solution(String numbers) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        char[] arrayCh = numbers.toCharArray();

        for (int i = 0; i < arrayCh.length - 1; i++) {
            for (int j = 1; j < arrayCh.length; j++) {
                set.add(Integer.parseInt(String.valueOf(arrayCh[i])+String.valueOf(arrayCh[j])));
            }
        }
        for (Integer integer : set) {
            System.out.println("integer = " + integer);
        }




        return count;
    }
*/

}