package com.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelectOrange {

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
//        int k = 2;
//        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        int solution = solution(k, tangerine);
        System.out.println("solution = " + solution);
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0, index = 0;
        Map<Integer, Integer> map;


        map = calMap(tangerine);

        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));


        while (k > 0) {
            k -= map.get(keyList.get(index));
            answer++;
            index++;
        }
        return answer;
    }

    public static Map<Integer, Integer> calMap(int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;

    }
}
