package com.programmers.level3;


/**
 * 2xN 타일링 level3(완성)
 *
 * */
public class Tilling {
    public static void main(String[] args) {
        int n = 4;
        int solution = solution(n);
        System.out.println("solution = " + solution);

    }


    //가로:2 세로: 1
    // % 1,000,000,007
    static int solution(int n) {
        int answer = 0;

        int num1 = 1, num2 = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = (num1 + num2) % 1000000007;
            num1 = num2;
            num2 = temp;
        }
        return num2;
    }
}
