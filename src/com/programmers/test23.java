package com.programmers;

public class test23 {
    public static void main(String[] args){
        //String s = "AB";
        String s = "a B z";
        int n = 4;
        String result = solution(s,n);

        System.out.println("result ==>" + result);
    }

    public static String solution(String s, int n) {
        String answer = "";

        StringBuilder builder = new StringBuilder();
        char[] str_split = s.toCharArray();


        //A-Z : 65~90
        //a-z : 97~122

        for(int i = 0; i < str_split.length;i++){
            char temp = str_split[i];
            if(temp==' ') {
                builder.append(" ");
                continue;
            }


            int temp_int = (int)temp;
            //System.out.println("temp1: " + temp + ", temp_int1:"+temp_int);
            temp_int += n;

            //System.out.println("temp2: " + temp + ", temp_int2:"+temp_int);
            if(temp_int >122){
                temp_int = temp_int % 122 + 96;
            }else if(temp_int > 90 && temp_int<97){
                temp_int = temp_int % 90 + 64;
            }

            builder.append((char)temp_int);


        }
        System.out.println("builder"+builder.toString());


        return builder.toString();
    }
}
