package com.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 단어변환 level3 (완성)
 *
 * */
public class ConvertWord {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};
        /**
         * "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다
         * */


        /**
         * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
         * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
         * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
         * begin과 target은 같지 않습니다.
         * 변환할 수 없는 경우에는 0를 return 합니다.
         * */

        int result = solution(begin, target, words);
        System.out.println("result =>" + result);
    }


    static int solution(String begin, String target, String[] words) {
        int answer = 0;
        String temp = begin;
        int i;
        int begin_length = begin.length();//시작 단어 길이
        boolean state = false;



        if(!Arrays.asList(words).contains(target)){
            return answer;
        }


        do {
            //temp 문자열이 target 문자열과 같을 때까지
            //즉 target값으로 변할 때까지 loop
            for (i = 0; i < words.length; i++) {
                // 주어진 String 배열 길이만큼 loop

                if (modify(temp, target)) {
                    return ++answer;
                }


                int count = 0; //target의 문자열과 특정 위치의 문자열의 단어차이를 뜻하는 변수
                for (int j = 0; j < begin_length; j++) {
                    //being_length => begin, target, words문자배열의 모든 문자열의 길이는 같음

                    if (temp.charAt(j) == words[i].charAt(j)) {
                        continue;
                    }else
                        count ++;

                }
                System.out.println("count = " + count);
                if (count <= 1) {
                    temp = words[i]; //시작 타겟을 변경
                    answer++;
                }
            }
        } while (!temp.equals(target));

        return answer;
    }

    static boolean modify(String word,String target) {
        boolean answer = false;
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                cnt++;
            }
        }

        if(cnt==1)
            answer = true;

        return answer;
    }
}
