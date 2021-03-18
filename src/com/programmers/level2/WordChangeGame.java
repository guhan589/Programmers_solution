package com.programmers.level2;

import java.util.ArrayList;

/**
 * 영어 끝말잇기Level 2 (완성)
 * */
public class WordChangeGame {
    public static void main(String[] args) {
//        int member = 3;
        int member = 2;
//        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = solution(member, words);
        System.out.println("result[0] = " + result[0]);
        System.out.println("result[1] = " + result[1]);

    }

    static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) {//같은 경우가 있을 경우
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            list.add(words[i]);

            /*if (list.size() > 1) {
                String str1 = list.get(i - 1);
                String str2 = list.get(i);

                System.out.println("str1.charAt(str1.length()-1) = " + str1.charAt(str1.length()-1));
                System.out.println("str1.charAt(str2.length()-1) = " + str1.charAt(str2.length()-1));
                if (str1.charAt(str1.length() - 1) != str2.charAt(0)) {
                    answer[0] = (i / n) + 1;
                    answer[1] = (i % n) + 1 ;

                    break;
                }

            }*/

            if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1 ;

                break;
            }
        }

        return answer;
    }


}
