package com.programmers.level2;

public class IntegrateDictionary {
    /**
     * 문제명 : 모음사전
     * 난이도 :level2
     * */
    public static void main(String[] args) {
//        String word = "AAAAE";
        String word = "AAAE";
//        "AAAAE"	6
//        "AAAE"	10
//        "I"	1563
//        "EIO"	1189
        int solution = solution(word);
        System.out.println("solution = " + solution);

    }
    public static int solution(String word) {
        int answer = 0;
        String order = "AEIOU"; // 사전 알파벳 모음 순서
        int[] value = {781,156,31,6,1};
        int index;
        answer = word.length();

        for (int i = 0; i < word.length(); i++) {
//            System.out.println("word.charAt(i) = " + word.charAt(i));
            index = order.indexOf(word.charAt(i));
//            System.out.println("index = " + index);
            answer += index*value[i];
        }

        return answer;
    }
}
