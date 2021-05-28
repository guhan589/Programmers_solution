package com.programmers.kstec;

import java.util.ArrayList;
import java.util.List;

public class Test5_2 {
    public static void main(String[] args) {
        int solution = solution(2);
        System.out.println("solution = " + solution);
    }
    public static int solution(int s) {
        int answer = 0;

        return getAliquot(s) * 2;
    }

    static int getAliquot(int num) {
        int min = num * 2; // 초기화
        for (int i = num - 1; i > 0; i--) {
            if (num % i == 0) {

                int temp = i + (num / i);
                if (min > temp) {
                    min = temp;
                }
            }
        }
        return min;
    }
}
