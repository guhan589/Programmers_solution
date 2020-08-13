package com.programmers;

import java.util.StringTokenizer;

public class test7 {

    public static void main(String[] args){
        String s = "3people unFollowed me";
        //String s= "for the last week";
        String result = solution(s);

        System.out.println("result--->"+result);
    }

    public static String solution(String s) {
        String answer = "";
        StringTokenizer token = new StringTokenizer(s," ");
        String[] str = new String[token.countTokens()];
        StringBuilder st_builder = new StringBuilder();


        int i = 0 , j=0;
        while(token.hasMoreTokens()){
            str[i++] =token.nextToken();
        }


        for(i = 0; i< str.length;i++){
            String str_temp = str[i];
            char ch = str_temp.charAt(j++);//Character.toString();
            int assci_code = (int)ch;
            while(assci_code<65){
                ch = str_temp.charAt(j++);//Character.toString();
                assci_code = (int)ch;
            }

            String temp_ch = String.valueOf(ch);

            temp_ch = temp_ch.toUpperCase();
            str_temp = ch+str_temp.substring(1, str_temp.length()).toLowerCase();
            if(i<str.length-1)
                st_builder.append(str_temp+" ");
            else
                st_builder.append(str_temp);
        }
        return String.valueOf(st_builder);
    }
}
