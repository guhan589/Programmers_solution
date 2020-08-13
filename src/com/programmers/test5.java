package com.programmers;

public class test5 {

    public static void main(String[] args){
        int n =78;

        int result = solution(n);
        System.out.print("result=-=>"+result);
    }

    public static int solution(int n) {
        int answer = 0;


        /*String[] split_n = Integer.toString(n,2).split("");

        for(int i = 0; i < split_n.length;i++) { //1의 개수 카운트
            if (split_n[i].equals("1"))
                count++;
        }*/


        String str= Integer.toString(n,2);
        str = str.replaceAll("0","");


        int len = str.length();


        n++;
        while(true){
            String str_to = Integer.toString(n,2);

            str_to = str_to.replaceAll("0","");

            int str_to_len = str_to.length();


            if(len==str_to_len)
                return n;

            n++;

        }


    }
}
