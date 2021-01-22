package com.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 단어변환
 * 
 * */
public class ConvertWord {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solution(begin, target, words);
        System.out.println("result =>" + result);
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Arrays.stream(words).forEach(System.out::println);
        ArrayList list = new ArrayList<>(Arrays.asList(words));

        if(list.contains(begin)|| list.contains(begin)){

        }else
            return 0;

        return answer;
    }
}
