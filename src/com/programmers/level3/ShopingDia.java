package com.programmers.level3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopingDia {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] solution = solution(gems);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Stream<String> distinct = Arrays.stream(gems).distinct();
        Object[] objects = distinct.toArray();
        for (Object object : objects) {
            System.out.println("object = " + object);
        }
        System.out.println("distinct = " + distinct);

        

        return answer;
    }
    /*public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            if(!map.containsKey(gems[i])) // map에 key가 없을경우
                map.put(gems[i], i + 1);
            else{
                map.replace(gems[i], i + 1);
            }

        }
        for (String s : map.keySet()) {
            System.out.println("+map.get(s) = " + s + "," + map.get(s));
        }
        Collection<Integer> values = map.values();
        answer[0] = values.stream().min(Integer::compare).orElse(-1);
        answer[1] = values.stream().max(Integer::compare).orElse(-1);

        System.out.println("answer[0] = " + answer[0]);
        System.out.println("answer[1] = " + answer[1]);


        return answer;
    }*/
}
