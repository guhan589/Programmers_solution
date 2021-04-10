package com.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Brain2 {
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

        List<String> list = new ArrayList<>();
        char ch;

        
        while (sentence.length() > 0) {

            if(sentence.length() < 3) //제약조건
                return "invalid";

            if (checkType(sentence, 0)) { // true: 소문자, false: 대문자
                //규칙2
                ch = sentence.charAt(0);
                int index = 0;
                for (int i = 1; i < sentence.length(); i++) {
                    if (ch == sentence.charAt(i)) { //처음과 마지막 문자가 같은경우
                        index = i;
                        break;
                    }
                }

                if (index == 0) {
                    return "invalid";
                } else {
                    list.add(sentence.substring(0, index + 1));
                    sentence = sentence.substring(index);

                }
            }else{ // 대문자
                if(!checkType(sentence,1)) //대문자
                    return "invalid";

                ch = sentence.charAt(1);
                int eIdx = -1;
                for (int i = 2; i < sentence.length(); i++) {
                    if(checkType(sentence, i)) {
                        eIdx = i;
                        if(sentence.charAt(eIdx) != ch) break;
                    }
                }
                if(eIdx == -1) return "invalid";


                while(eIdx >= 1) {
                    if(ch == sentence.charAt(eIdx)) break;
                    eIdx--;
                }

                list.add(sentence.substring(0, eIdx+2));
                sentence = sentence.substring(eIdx+2);

            }
        }
        for (String s : list) {
            answer += s +" ";
        }

        return answer.trim(); //양쪽 공백 제거
    }

    static String convertToString(String str) {
        if(checkType(str,0))
            str = str.replace(str.charAt(0), ' ');
        if(checkType(str,1))
            str = str.replace(str.charAt(1), ' ');
        if(checkType(str,2))
            str = str.replace(str.charAt(2), ' ');
        return str.replace(" ", "");
    }
    static boolean checkType(String sentence, int index) {
        if (sentence.charAt(index) >= 'a' && sentence.charAt(index) <= 'z')
            return true; //소문자로 시작할 떄
        else
            return false; // 대문자로 시작할 때

    }
}
