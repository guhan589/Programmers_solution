package com.programmers.level2;

public class Pointing {
    public static void main(String[] args) {
        int k = 2, d = 3;
        long solution = solution(k, d);
        System.out.println("solution = " + solution);
    }
    public static long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i+=k) {
            
            /**
             * Math 함수를 이용
             * pow: 제곱
             * sqrt: 제곱근
             * floor: 소수값 버림
             * */
            double sqrt = Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            double floor = Math.floor(sqrt) + 1;
            answer += floor;
        }
        return answer;
    }
}
