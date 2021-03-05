package com.programmers.level2;

public class ListOfMatch {
    public static void main(String[] args) {
        int N = 8, A = 4, B = 7;
        int result = solution(N, A, B);
        System.out.println("result==>"+result);
    }
    public static int solution(int n, int a, int b) {
        int answer = 1;
        int left = 0;
        int right = 0;

        if (a > b) {
            left = b;
            right = a;
        } else {
            left = a;
            right = b;
        }

        while (left % 2 == 0 || right - left != 1) {

            left = (left + 1) / 2;
            right = (right + 1) / 2;
            answer++;
        }

        return answer;
    }
}
