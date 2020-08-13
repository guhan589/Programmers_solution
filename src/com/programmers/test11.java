package com.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*최댓값 최솟값*/
public class test11 {
    public static void main(String[] args){
        String s = "1 2 3 4";
        //String s ="-1 -2 -3 -4";
        //String s = "-1 1";
        String result = solution(s);
        System.out.println("s===>"+result);
    }
    public static String solution(String s) {
        String answer = "";
        String[] buffer = s.split(" ");

        int min_temp = 0;//최소값
        int max_temp = 0; //최대값
        
        for(int i = 0 ; i< buffer.length; i++){
            if(i==0){
                min_temp = Integer.parseInt(buffer[i]);
                max_temp = Integer.parseInt(buffer[i]);
            }else{
                if(min_temp>Integer.parseInt(buffer[i]))
                    min_temp = Integer.parseInt(buffer[i]);

                if(Integer.parseInt(buffer[i])>max_temp)
                    max_temp = Integer.parseInt(buffer[i]);
                
            }
        }
        
            

        answer = min_temp + " " + max_temp;

        return answer;

    }
}
