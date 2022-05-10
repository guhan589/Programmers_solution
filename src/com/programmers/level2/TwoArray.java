package com.programmers.level2;

public class TwoArray {
    public static void main(String[] args) {
        int n = 3 ;
        long left = 2;
        long right  = 5;
        int[] solution = solution(n, left, right);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
    public static int[] solution(int n, long left, long right) {
        int[] answer = {};
        int cnt = 0;
        long size = right - left + 1;
        answer = new int[(int) size];
        long[] ints = fillArea(n);
        for (long i = left; i <= right; i++) {
            answer[cnt++] = (int) ints[(int) i];
        }
        return answer;
    }

    public static long[] fillArea(int n) {
        long[][] array = new long[n][n];
        long[] answer = new long[n * n];
        long cnt = 0;
        int num = 1;

        for (int z = 0; z < n; z++) {
            for (int i = 0; i <= z; i++) {
                array[i][z] = num;
                array[z][i] = num;
                array[z][z] = num;
            }
            num++;
        }
        for (long[] ints : array) {
            for (long anInt : ints) {
                answer[(int) cnt++] = anInt;
            }
        }
        return answer;
    }
}
