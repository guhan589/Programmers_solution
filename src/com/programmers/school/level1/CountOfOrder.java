package com.programmers.school.level1;

public class CountOfOrder {
    public static void main(String[] args) {
        int n = 20;
        int solution = solution(n);
        System.out.println("solution = " + solution);
    }
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                answer++;
            }

        }
        return answer + 1;
    }
}
