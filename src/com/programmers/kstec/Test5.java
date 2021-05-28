package com.programmers.kstec;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
    static int argx = 0;
    static int remainder = 0;
    public static void main(String[] args) {
        int solution = solution(100);
        System.out.println("solution = " + solution);
    }
    public static int solution(int s) {
        int answer = 0;

        getValue(s);
        System.out.println("argx = " + argx);
        System.out.println("remainder = " + remainder);
        return (argx + remainder) * 2;
    }
    static void getValue(int s) {
        if (s % 2 == 0) {
            argx += 2;
            getValue(s / 2);
        }else
            remainder = s;
    }
}
/**
 * int temp = s;
 *         int i = 0;
 *         if (s / 2 == 0) {
 *             answer[0] = 1;
 *             answer[1] = 2;
 *             return answer;
 *         }
 *         while (temp != 0) {
 *             if (temp % 2 == 0) { //짝수는 계속 나눈다
 *                 System.out.println("temp = " + temp);
 *                 ++i;
 *                 temp = temp / 2;
 *             } else {
 *                 answer[0] = i * 2;
 *                 answer[1] = temp;
 *                 return answer;
 *             }
 *         }
 *         */
