package com.programmers.level2;

import java.util.Scanner;

public class LongJump {
    static int tempValue = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long solution = solution(scanner.nextInt());
        System.out.println("solution = " + solution);

    }

    public static long solution(int n) {
        long answer = 0;
        for (int i = 1; i <= 2; i++) { // 1과 2만 있으니.
            if (calSolution(n, tempValue, i)) {
                calSolution(n, tempValue, i);
            } else {

            }
        }
        return answer % 1234567;
    }

    public static boolean calSolution(int n, int tempValue, int value) {

        tempValue += value;
        System.out.println("tempValue = " + tempValue);
        if (tempValue <= n) {
            return true;
        }else{
            return false;
        }
    }
}
