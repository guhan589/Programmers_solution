package com.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Weapon {

    public static void main(String[] args) {
        int number = 5, limit = 3, power = 2;
        int solution = solution(number, limit, power);
        System.out.println("solution = " + solution);
    }
    public static int solution(int number, int limit, int power) {
        int answer = 0;


        for (int i = 1; i <= number; i++) {
            int count = 0;
//            System.out.print("i = " + i+" ");

            for (int j = 1; j * j <= i; j++) {
//                System.out.println("j = " + j);
                if (j * j == i) count++;
                else if (i % j == 0) count += 2;

            }

            answer += count > limit ? power : count;

        }
        return answer;
    }




}
