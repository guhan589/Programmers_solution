package com.programmers.level1;

import java.util.Arrays;

public class SumNotNumber {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 6, 7, 8, 0};
//        int[] number = {5, 8, 4, 0, 6, 7, 9};
        int solution = solution(number);
        System.out.println("solution = " + solution);
    }
    /*public static int solution(int[] numbers) {
        int answer = -1;
        int cnt = 0 ;
        int sum = 0 ;
        Arrays.sort(numbers);

        for (int number : numbers) {
            System.out.println("number = " + number);
            System.out.println("cnt = " + cnt);
            if(cnt != number){
                for(int i = cnt; i< number ;i++)
                    sum += i;
                cnt = number;
            }
            System.out.println("sum = " + sum);
            cnt++;
        }


        return sum;
    }*/
    public static int solution(int[] numbers) {
        int answer = -1;
        int cnt = 0 ;
        int sum = 0 ;

        for (int number : numbers) {
           sum+=number;
        }


        return 45-sum;
    }
}
