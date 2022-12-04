package com.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelectOrange {

    public static void main(String[] args) {
        int k = 4;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int solution = solution(k, tangerine);
        System.out.println("solution = " + solution);
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map;
        map = calMap(tangerine);
        for (Integer integer : map.keySet()) {
            System.out.print("integer = " + integer);
            System.out.println("  /  = " + map.get(integer));
        }
//        List<Integer> list = new ArrayList<>();




        return answer;
    }

    public static Map<Integer, Integer> calMap(int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            if (map.containsKey(i)) {//중복 값이 있을 시
                map.put(i, map.get(i) + 1);
            }else
                map.put(i, 1);
        }
        return map;

    }
}
