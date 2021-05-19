package com.programmers.kakao;

public class TechDevelopersTest1 {
    static String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void main(String[] args) {
//        String s = "one4seveneight";
        String s = "2three45sixseven";
        int solution = solution(s);
        System.out.println("solution = " + solution);

    }
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.contains(words[i]))
                s = s.replaceAll(words[i], String.valueOf(i));

        }
        return Integer.parseInt(s);
    }

}
