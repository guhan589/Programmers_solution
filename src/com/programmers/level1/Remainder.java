package com.programmers.level1;

public class Remainder {
    public static void main(String[] args) {
        int n = 10;
        int solution = solution(n);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 1) {
                return i;

            }
        }
            return answer;
    }
}
