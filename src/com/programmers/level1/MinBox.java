package com.programmers.level1;

import java.util.*;

public class MinBox {

    public static void main(String[] args) {
        
        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};
        int solution = solution(sizes);
        System.out.println("solution = " + solution);
    }// 5600 --> 4000

    public static int solution(int[][] sizes) {
        int answer = 0;
        int min = 0;
        int max = 0;
        for(int i = 0; i < sizes.length; i++){
             int temp_max = Math.max(sizes[i][0],sizes[i][1]);
             int temp_min = Math.min(sizes[i][0],sizes[i][1]);
             max = Math.max(temp_max,max);
             min = Math.max(temp_min,min);
        }
         return max*min;
    }

}
