package com.programmers.level1;

public class Ternary_scale {
    /**
     * 3진법 뒤집기
     * **/
    public static void main(String[] args) {
        int n = 45;
        int result = solution(n);
        System.out.println("result ==>"+result);
    }
    public static int solution(int n) {
        int answer = 0;

        String temp = re_parsing(n,"");

        for(int i = 0; i< temp.length();i++){
            answer += Integer.parseInt(String.valueOf(temp.charAt(i))) * (re_int(temp.length()-i-1,1));
        }
        return answer;

    }
    static int re_int(int num,int value){
        int temp = value * 3;
        if(num>0)
            return re_int(--num,temp);
        else
            return value;
    }
    static String re_parsing(int num,String value){
        int temp1 = num / 3;
        int temp2 = num % 3;
        value = value+String.valueOf(temp2);
        if(temp1>0)
            return re_parsing(temp1,value);
        else
            return value;


    }
}
