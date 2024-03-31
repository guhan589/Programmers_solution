package com.programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PrimitiveIterator;

public class HashFunction {
    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2, row_begin = 2, row_end = 3;
        int solution = solution(data, col, row_begin, row_end);
        System.out.println("solution = " + solution);
    }
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[col-1]==o2[col-1]?o2[col-1]-o1[0]:o1[col-1]-o2[col-1];
            }
        });

        for (int i = row_end - 1; i < row_end; i++) {

        }


        return answer;
    }


}
