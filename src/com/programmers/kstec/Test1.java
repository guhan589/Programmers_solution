package com.programmers.kstec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test1 {
    static int MATRIX_LEN;
    public static void main(String[] args) {
        int[][] matrix = {{1, 19, 20, 8, 25}, {21, 4, 3, 17, 24}, {12, 5, 6, 16, 15}, {11, 18, 10, 9, 23}, {7, 13, 14, 22, 2}};
        int solution = solution(matrix);
        System.out.println("solution = " + solution);
    }
    public static int solution(int[][] matrix) {
        int answer = 0;
        MATRIX_LEN = matrix.length;
        List<Integer> raw_result = findRaw(matrix);
        List<Integer> cal_result = findCalum(matrix);

        for (Integer integer : raw_result) {
            if (cal_result.contains(integer)) {
                answer++;
            }
        }
        return answer;
    }

    static List<Integer> findRaw(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < MATRIX_LEN; i++) {
            int[] calTemp = new int[MATRIX_LEN];
            int[] raw = matrix[i];
            for (int j = 0; j < MATRIX_LEN; j++) {
                calTemp[j] = raw[j];
            }

            Arrays.sort(calTemp);// 오름차순 정렬

            list.add(calTemp[MATRIX_LEN / 2]);
        }
        return list;
    }

    static List<Integer> findCalum(int[][] matrix) {
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < MATRIX_LEN; i++) {
            int[] calTemp = new int[MATRIX_LEN];
            for (int j = 0; j < MATRIX_LEN; j++) {
                calTemp[j] = matrix[j][i];
            }
            Arrays.sort(calTemp);// 오름차순 정렬

            list.add(calTemp[MATRIX_LEN / 2]);

        }
        return list;
    }
}