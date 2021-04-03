package com.programmers.kakao;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;
        int solution = solution(needs, r);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] needs, int r) {
        int answer = 0;

        //r은 1 이상 needs의 가로(열) 길이 이하인 자연수입니다.
        if (r > needs.length)
            return answer;

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < needs.length; i++) {
            for (int j = 0; j < needs[i].length; j++) {
                if (needs[i][j] == 1 && map.get(i) != null) {
                    map.put(i, String.valueOf(map.get(i))+","+String.valueOf(j));
                } else if (needs[i][j] == 1) {
                    map.put(i, String.valueOf(j));
                }

            }
        }
        for (int s : map.keySet()) {
            System.out.println("map.get(s) = " + map.get(s));
        }
        List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }); // value 오름차순 정렬

        for (Map.Entry<Integer, String> entry : list) {
            System.out.println("entry = " + entry);
        }

        for (Map.Entry<Integer, String> entry : list) {
           /* if (result.get(entry.getValue()) != null) {
                result.put(entry.getValue(),result.get(entry.getValue())+1);
            }else
                result.put(entry.getValue(),1);*/
            result.merge(entry.getValue(), 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
            System.out.println("stringIntegerEntry = " + stringIntegerEntry);
        }
        Object[] objects = result.keySet().toArray();
        for (int i = 0; i < objects.length-1; i++) {
            if (objects[i].toString().length() == 1) {
                for (int j = i + 1; j < objects.length; j++) {
//                    if(objects[i].toString().contains(result.get(objects[j].toString())))
                }
            }
        }



        return answer;

    }
}
