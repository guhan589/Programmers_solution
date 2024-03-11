package com.programmers.pccp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        String input_string = "string";
        String solution = solution(input_string);
        System.out.println("solution = " + solution);

    }
    public static String solution(String input_string) {
        String answer = "";
        char tempChar = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = input_string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(tempChar == chars[i]){
                continue;
            }else {
                tempChar = chars[i];
                map.put(tempChar, map.getOrDefault(tempChar,0) + 1);
            }
        }

        for (Character character : map.keySet()) {
            if(map.get(character)>=2)
                answer+=character;
        }


        return answer.equals("")?answer="N":answer;
    }
}

