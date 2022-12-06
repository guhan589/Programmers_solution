package com.programmers.level1;

public class DivideString {
    public static void main(String[] args) {
        String s = "abracadabra";
        int solution = solution(s);
        System.out.println("solution = " + solution);
    }
    public static int solution(String s) {
        /**
         * level1 문자열 나누기
         * 
         * */
        char first = s.charAt(0);
        int count = 0;
        int diff = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == diff) {
                answer++;
                first = s.charAt(i);
            }
            if (first == s.charAt(i)) {
                count++;
            } else {
                diff++;
            }
        }
        return answer;
    }
}
