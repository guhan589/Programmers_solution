package com.programmers.kstec;

import java.util.*;

public class Test2 {
    static String GROUP = "A B";
    public static void main(String[] args) {
//        String vote = "ABBCCCBBAB";
//        String vote = "AABBC";
//        String vote = "AABBCC";
        String vote = "ABC";
        String solution = solution(vote);
        System.out.println("solution = " + solution);


    }
    public static String solution(String vote) {
        String answer = "";
        /**
         *  'A'팀과 'B'팀이 있습니다. 동아리 회원들의 투표를 통해 가장 많은 표를 받은 팀이 대표팀이 됩니다.
         *  만약, 'A'팀과 'B'팀의 득표수가 같다면 두 팀 모두 대표 팀으로 선정됩니다.
         * */
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        String[] splitStr= vote.split("");
        Arrays.sort(splitStr);
        for (int i = 0; i < splitStr.length; i++) {
            String temp = splitStr[i];

            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }



        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            //Value값으로 오름차순정렬
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {

                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        for (Map.Entry<String, Integer> list_entry : list_entries) {
            System.out.println("list_entry = " + list_entry);
        }
        int maxValue = 0;
        String resultKey="";
        for (Map.Entry<String, Integer> entry : list_entries) {
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                resultKey = entry.getKey();
            }else{
                if (maxValue == value) {

                    
                    if (resultKey.equals("C") || entry.getKey().equals("C")) { //A,B와 C 횟수가 같을 수 있는 경우
                        return "C";
                    } else if (map.get("C") == entry.getValue()) {
                        return "C";
                    } else if (GROUP.contains(resultKey) || GROUP.contains(entry.getKey())) {
                        return "AB";
                    }
                }
            }
        }
        return resultKey;
    }
}
