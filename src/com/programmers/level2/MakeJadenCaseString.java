package com.programmers.level2;

import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * JadenCase 문자열 만들기 (완성)
 * */
public class MakeJadenCaseString {

    public static void main(String[] aegs){
        String s = "3people  unFollowe d me";
        //String s = "p";

        String result = solution(s);
        System.out.println("result==>" + result);

    }
    static String solution(String s){
        String answer = "";
        StringBuilder builder = new StringBuilder();


        if(s.length()==1) //문자열 길이가 1일때는
            return s.toUpperCase();
        s  = s.toLowerCase();
        String[] split_str = s.split(" ");//공백 기준으로 문자열 분리

        for(int i = 0 ; i < split_str.length; i++){
            if(split_str[i].length()>=1){
                char[] ch = split_str[i].toCharArray();
                ch[0] = Character.toUpperCase(ch[0]);//문장에 첫글자 대문자로 변환
                split_str[i] = new String(ch);
            }
        }

        builder.append(split_str[0]);
        for(int i = 1; i<split_str.length;i++){
            builder.append(" " + split_str[i]) ;
        }
        String temp = builder.toString();
        if(temp.length() != s.length()){
            int gap = s.length() - temp.length();
            for(int i = 0; i < gap;i++)
                builder.append(" ");
        }
        return builder.toString();

    }
    static String solution2(String s){
        
        /**
         * 
         * 준식이형 코드
         * */
        StringBuilder builder=new StringBuilder();
        boolean check=true;
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(!Character.isSpace(c)){
                if(check){
                    c=Character.toUpperCase(c);
                    check=false;
                }
                else {
                    c=Character.toLowerCase(c);
                }
                builder.append(c);
            }else{
                builder.append(c);
                check=true;
            }
        }
        return builder.toString();

    }
}
