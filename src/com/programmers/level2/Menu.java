package com.programmers.level2;

import java.util.*;

public class Menu {
    /**
     * 메뉴리뉴얼 level2 (완성)
     *
     * */
    static Map<String, Integer> map;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String[] orders1= {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        String[] orders1 = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] result = solution(orders1, course);
        for (String s : result) {
            System.out.println("result = " + s);
        }
    }

    public static String[] solution(String[] orders, int[] coures) {
        String[] answer;
        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();//String convert to char
            Arrays.sort(ch);
            for (int index = 0; index < ch.length - 1; index++) {// ch[] 배열
                for (int co = 0; co < coures.length; co++) { // 주문 수
                    dfs(ch, index, coures[co], String.valueOf(ch[index]));
                }

            }
        }

        addMap(list); // list에 모든 값을 HashMap에 put하는 함수 호출


        //key값을 기준으로 sort

        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList,(o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        List<String> resultList = new ArrayList<>();
        for (int index = 0; index < coures.length; index++) {
            int max = 0;

            for (String s : keyList) {
                if (map.get(s) >= 2 && s.length() == coures[index]) {
                    if (map.get(s) >= max) {
                        resultList.add(s);
                        max = map.get(s);
                    }
                }

            }
        }

        Collections.sort(resultList);
        answer = new String[resultList.size()];
        int i = 0;
        for (String s : resultList) {
            answer[i++] = s;
        }
        return answer;
    }

    static void addMap(List<String> list) {
        map = new HashMap<>();
        for (String s : list) {
            map.put(s,map.getOrDefault(s, 0) + 1);
        }
    }
    static void dfs(char[] ch, int index, int coure, String str) {
        if (str.length() == coure)
            list.add(str);

        for (int i = index + 1; i < ch.length; i++)
            dfs(ch,i,coure,str+ch[i]);

    }
}
