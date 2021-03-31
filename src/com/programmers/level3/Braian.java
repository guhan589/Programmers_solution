package com.programmers.level3;

import java.util.HashSet;
import java.util.Set;

public class Braian {

    /**
     * 브라이언의 고민 level3(미완성)
     * */
    private static boolean status;
    private static char front_ch, back_ch;


    /**
     * 1. 위의 두 가지 규칙은 한 단어에 모두 적용될 수 있지만 같은 규칙은 두 번 적용될 수 없다.
     * 2. 규칙 1과 규칙2를 모두 적용하고 단어 사이에 공백을 하나 추가하여 반환한다.
     * **/
    public static void main(String[] args) {
        //"HaEaLaLaObWORLDb"	"HELLO WORLD"
        //"SpIpGpOpNpGJqOqA"	"SIGONG JOA"
        //"AxAxAxAoBoBoB"	"invalid

//        String sentence = "HaEaLaLaObWORLDb";
//        String sentence = "AxAxAxAoBoBoB";
        String sentence = "SpIpGpOpNpGJqOqA";
        String solution = solution(sentence);

        System.out.println("solution = " + solution);
    }
    static String solution(String sentence) {
        String answer = "";
        //원래의 문구의 경우 문장 앞뒤의 공백이 없어야 한다.
        //단어 사이의 공백은 한 글자여야 한다.

        sentence = sentence.replaceAll(" ", ""); // 우선 공백제거
        answer = pattern1(sentence);
        return answer;
    }



    //한 단어 두개 이상의 단어를 이용하면 안됨 abHelloba
    static String pattern1(String sentence) {
        /**
         * (규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다.
         * ex) HELLO -> HaEaLaLaO
         * */
        String answer = "";
        int index = 0;

        Set<Character> set = new HashSet<>(); //중복제거를 위한 Set사용
        StringBuilder builder = new StringBuilder();//문자열 조합을 위한 변수

        for (int i = 1; i < sentence.length(); i = i + 2) {
            builder.append(sentence.charAt(i - 1));
            set.add(sentence.charAt(i)); //중복방지
            if (set.size() > 1) {
                index = i; //규칙 1번과 2번이 경계션
                break;
            }
        }
        front_ch = set.stream().findFirst().get(); //앞글자
        
        if (index == 0) { //규칙 1로만 구성되어 있을경우 "invalid" 문자열 반환
            return "invalid";
        }else{
            String result2 = pattern2(sentence.substring(index));
            if(result2.equals("invalid"))
                return "invalid";
            else{
                builder.append(" " + result2);
                return builder.toString();
            }

        }
//        return answer;
    }
    static String pattern2(String sentence) {
        /**
         * (규칙 2) 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다.
         * ex) WORLD -> bWORLDb
         * */
        String answer = "";


        char[] split_str = sentence.toCharArray();
        if (split_str[0] == split_str[split_str.length - 1]&& split_str[0] != front_ch) {
            if (split_str[1] == split_str[split_str.length - 2] && split_str[1] != front_ch) {
                if(split_str[0] != split_str[1])
                    return "invalid";
                else return "invalid";
            } else {
                return sentence.substring(1, sentence.length() - 1);
            }
        }else
            return "invalid";
    }
    /*static boolean pattern3(String sentence) {
        status = false;


        return status;
    }*/

}
